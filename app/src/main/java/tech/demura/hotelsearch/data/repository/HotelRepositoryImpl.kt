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
import tech.demura.hotelsearch.data.retrofit.network.ApiService
import tech.demura.hotelsearch.domain.entity.Hotel
import tech.demura.hotelsearch.domain.repository.HotelRepository
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    val apiService: ApiService,
    val hotelMapper: HotelMapper
) : HotelRepository {

    // SCOPE
    val coroutineScope = CoroutineScope(Dispatchers.Default)

    // HOTEL LIST CONTAINER
    private val _hotelList = mutableListOf<Hotel>()
    private val hotelList: List<Hotel>
        get() = _hotelList.toList()

    // HOTEL LIST FLOW
    private val nextHotelNeededEvent = MutableSharedFlow<Unit>(replay = 1)
    private val loadedHotelListFlow = flow {
        nextHotelNeededEvent.emit(Unit)
        nextHotelNeededEvent.collect {
            _hotelList.add(getHotel())
            emit(hotelList)
        }
    }
    private val hotelListFlow: StateFlow<List<Hotel>> =
        loadedHotelListFlow
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.Lazily,
                initialValue = hotelList
            )

    // DOWNLOAD HOTEL
    private suspend fun getHotel(): Hotel {
        val defHotel = coroutineScope.async {
            apiService.getHotelInfo()
        }
        val response = defHotel.await()
        return hotelMapper.mapHotelModelToHotel(response)
    }

    // RETURN HOTEL LIST STATE FLOW
    override fun getHotelStateFlow(): StateFlow<List<Hotel>> = hotelListFlow

}