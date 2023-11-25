package tech.demura.hotelsearch.domain.use_case

import tech.demura.hotelsearch.domain.repository.RoomRepository
import javax.inject.Inject

class LoadNextRoomUseCase @Inject constructor(private val repository: RoomRepository) {
    suspend operator fun invoke(){
        repository.loadNextRoom()
    }
}