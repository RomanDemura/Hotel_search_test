package tech.demura.hotelsearch.domain.use_case

import kotlinx.coroutines.flow.StateFlow
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.domain.repository.BookingRepository
import javax.inject.Inject

class GetBookingInfoStateFlowUseCase @Inject constructor(private val repository: BookingRepository) {
    operator fun invoke(): StateFlow<BookingInfo> {
        return repository.getBookingInfoStateFlow()
    }
}
