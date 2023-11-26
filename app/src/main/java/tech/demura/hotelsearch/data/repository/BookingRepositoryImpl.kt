package tech.demura.hotelsearch.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import tech.demura.hotelsearch.data.retrofit.mapper.BookingInfoMapper
import tech.demura.hotelsearch.data.retrofit.network.ApiService
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.domain.repository.BookingRepository
import javax.inject.Inject

class BookingRepositoryImpl @Inject constructor(
    val apiService: ApiService,
    val bookingInfoMapper: BookingInfoMapper
) : BookingRepository {

    //SCOPE
    val coroutineScope = CoroutineScope(Dispatchers.Default)

    // BOOKING INFO CONTAINER
    private var _bookingInfo = BookingInfo()
    private val bookingInfo: BookingInfo
        get() = _bookingInfo.copy()

    // BOOKING INFO FLOW
    private val nextBookingInfoNeededEvent = MutableSharedFlow<Unit>(replay = 1)
    private val loadedBookingInfoFlow = flow {
        nextBookingInfoNeededEvent.emit(Unit)
        nextBookingInfoNeededEvent.collect {
            _bookingInfo = getBookingInfo()
            emit(bookingInfo)
        }
    }
    private val bookingInfoFlow: StateFlow<BookingInfo> =
        loadedBookingInfoFlow
            .stateIn(
                scope = coroutineScope,
                started = SharingStarted.Lazily,
                initialValue = bookingInfo
            )

    // DOWNLOAD DATA
    private suspend fun getBookingInfo(): BookingInfo {
        val defBookingInfo = coroutineScope.async {
            apiService.getBookingInfo()
        }
        val response = defBookingInfo.await()
        return bookingInfoMapper.mapBookingInfoModelToBookingInfo(response)
    }

    // RETURN STATE FLOW
    override fun getBookingInfoStateFlow(): StateFlow<BookingInfo> =
        bookingInfoFlow
}