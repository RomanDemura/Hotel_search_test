package tech.demura.hotelsearch.domain.entity

sealed class HotelScreenState {

    object Initial : HotelScreenState()

    object Loading : HotelScreenState()

    data class HotelsInfo(
        val hotelsInfo: List<Hotel>,
        val isLoading: Boolean = false
    ) : HotelScreenState()
}