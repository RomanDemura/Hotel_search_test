package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.runtime.Composable
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.presentation.views.FooterHotelInfo
import tech.demura.hotelsearch.presentation.views.ThemedCard

@Composable
fun HotelInfoCard(
    bookingInfo: BookingInfo
){
    ThemedCard {
        FooterHotelInfo(
            name = bookingInfo.hotel_name,
            rating = bookingInfo.horating,
            ratingName = bookingInfo.rating_name,
            address = bookingInfo.hotel_adress
        )
    }
}