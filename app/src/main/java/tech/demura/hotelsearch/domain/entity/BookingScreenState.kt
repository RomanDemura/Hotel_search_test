package tech.demura.hotelsearch.domain.entity

sealed class BookingScreenState {
    object Initial : BookingScreenState()
    object Loading : BookingScreenState()
    data class Info(val bookingInfo: BookingInfo) : BookingScreenState()
}
