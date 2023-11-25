package tech.demura.hotelsearch.domain.repository

import kotlinx.coroutines.flow.StateFlow
import tech.demura.hotelsearch.domain.entity.Hotel

interface HotelRepository {

    fun getHotelStateFlow(): StateFlow<List<Hotel>>

    suspend fun loadNextHotel()
}