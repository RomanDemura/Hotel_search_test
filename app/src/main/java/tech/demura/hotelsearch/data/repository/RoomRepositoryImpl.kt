package tech.demura.hotelsearch.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import tech.demura.hotelsearch.data.retrofit.mapper.HotelMapper
import tech.demura.hotelsearch.data.retrofit.mapper.RoomMapper
import tech.demura.hotelsearch.data.retrofit.network.ApiFactory
import tech.demura.hotelsearch.data.retrofit.network.ApiService
import tech.demura.hotelsearch.domain.entity.Hotel
import tech.demura.hotelsearch.domain.entity.Room
import tech.demura.hotelsearch.domain.repository.RoomRepository
import tech.demura.hotelsearch.extensions.mergeWith
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    val apiService: ApiService,
    val roomMapper: RoomMapper
): RoomRepository {
    val coroutineScope = CoroutineScope(Dispatchers.Default)

    // Room list container
    private val _roomList = mutableListOf<Room>()
    private val roomList: List<Room>
        get() = _roomList.toList()

    // Room flow
    private val nextRoomNeededEvent = MutableSharedFlow<Unit>(replay = 1)
    private val refreshedRoomFlow = MutableSharedFlow<List<Room>>()
    private val loadedRoomListFlow = flow {
        loadNextRoom() // load first data
        nextRoomNeededEvent.collect {
            _roomList.addAll(getRoomList())
            emit(roomList)
        }
    }
    private val hotelListFlow: StateFlow<List<Room>> =
        loadedRoomListFlow
            .mergeWith(refreshedRoomFlow)
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.Lazily,
                initialValue = roomList
            )

    private suspend fun getRoomList(): List<Room> {
        val defRooms = coroutineScope.async {
            apiService.getRoomList()
        }
        val response = defRooms.await()
        return roomMapper.mapListRoomModelToListRoom(response)
    }

    override fun getRoomStateFlow(): StateFlow<List<Room>> = hotelListFlow

    override suspend fun loadNextRoom() {
        nextRoomNeededEvent.emit(Unit)
    }
}