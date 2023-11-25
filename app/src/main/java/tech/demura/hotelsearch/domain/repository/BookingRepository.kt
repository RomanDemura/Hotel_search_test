package tech.demura.hotelsearch.domain.repository

import kotlinx.coroutines.flow.StateFlow
import tech.demura.hotelsearch.domain.entity.BookingInfo

interface BookingRepository {

    fun getBookingInfoStateFlow(): StateFlow<BookingInfo>
}