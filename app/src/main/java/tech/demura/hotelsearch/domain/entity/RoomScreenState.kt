package tech.demura.hotelsearch.domain.entity

sealed class RoomScreenState{

    object Initial: RoomScreenState()

    object Loading: RoomScreenState()

    data class RoomsInfo(
        val rooms: List<Room>,
        val isLoading: Boolean = false
    )
}
