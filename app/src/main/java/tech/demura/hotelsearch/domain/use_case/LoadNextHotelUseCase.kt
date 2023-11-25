package tech.demura.hotelsearch.domain.use_case

import tech.demura.hotelsearch.domain.repository.HotelRepository
import javax.inject.Inject

class LoadNextHotelUseCase @Inject constructor (private val repository: HotelRepository) {
    suspend operator fun invoke(){
        return repository.loadNextHotel()
    }
}