package tech.demura.hotelsearch.domain.use_case

import kotlinx.coroutines.flow.StateFlow
import tech.demura.hotelsearch.domain.entity.Room
import tech.demura.hotelsearch.domain.repository.RoomRepository
import javax.inject.Inject

class GetRoomStateFlowUseCase @Inject constructor (private val repository: RoomRepository) {
    operator fun invoke(): StateFlow<List<Room>> {
        return repository.getRoomStateFlow()
    }
}