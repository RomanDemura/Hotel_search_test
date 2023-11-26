package tech.demura.hotelsearch.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import tech.demura.hotelsearch.data.retrofit.mapper.RoomMapper
import tech.demura.hotelsearch.data.retrofit.network.ApiService
import tech.demura.hotelsearch.domain.entity.Room
import tech.demura.hotelsearch.domain.repository.RoomRepository
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    val apiService: ApiService,
    val roomMapper: RoomMapper
) : RoomRepository {

    // SCOPE
    val coroutineScope = CoroutineScope(Dispatchers.Default)

    // ROOM LIST CONTAINER
    private val _roomList = mutableListOf<Room>()
    private val roomList: List<Room>
        get() = _roomList.toList()

    // ROOM LIST FLOW
    private val nextRoomNeededEvent = MutableSharedFlow<Unit>(replay = 1)
    private val loadedRoomListFlow = flow {
        nextRoomNeededEvent.emit(Unit)
        nextRoomNeededEvent.collect {
            _roomList.addAll(getRoomList())
            emit(roomList)
        }
    }
    private val roomListFlow: StateFlow<List<Room>> =
        loadedRoomListFlow
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.Lazily,
                initialValue = roomList
            )

    // DOWNLOAD ROOM LIST
    private suspend fun getRoomList(): List<Room> {
        val defRooms = coroutineScope.async {
            apiService.getRoomList()
        }
        val response = defRooms.await()
        return roomMapper.mapListRoomModelToListRoom(response)
    }

    // RETURN ROOM LIST STATE FLOW
    override fun getRoomStateFlow(): StateFlow<List<Room>> = roomListFlow

}