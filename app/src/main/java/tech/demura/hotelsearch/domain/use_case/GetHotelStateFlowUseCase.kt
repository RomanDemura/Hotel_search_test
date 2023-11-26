package tech.demura.hotelsearch.domain.use_case

import kotlinx.coroutines.flow.StateFlow
import tech.demura.hotelsearch.domain.entity.Hotel
import tech.demura.hotelsearch.domain.repository.HotelRepository
import javax.inject.Inject

class GetHotelStateFlowUseCase @Inject constructor(private val repository: HotelRepository) {
    operator fun invoke(): StateFlow<List<Hotel>> {
        return repository.getHotelStateFlow()
    }
}