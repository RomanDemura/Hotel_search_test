package tech.demura.hotelsearch.domain.repository

import kotlinx.coroutines.flow.StateFlow
import tech.demura.hotelsearch.domain.entity.Room

interface RoomRepository {

    fun getRoomStateFlow(): StateFlow<List<Room>>

    suspend fun loadNextRoom()
}