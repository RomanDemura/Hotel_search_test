package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.presentation.views.PairRow

@Composable
fun TravelInfo(bookingInfo: BookingInfo){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        PairRow(leftText = "Вылет из", rightText = bookingInfo.departure)
        PairRow(leftText = "Страна, город", rightText = bookingInfo.arrival_country)
        PairRow(leftText = "Даты", rightText = "${bookingInfo.tour_date_start} - ${bookingInfo.tour_date_stop}")
        PairRow(leftText = "Кол-во ночей", rightText = "${bookingInfo.number_of_nights} ночей")
        PairRow(leftText = "Отель", rightText = bookingInfo.hotel_name)
        PairRow(leftText = "Номер", rightText = bookingInfo.room)
        PairRow(leftText = "Питание", rightText = bookingInfo.nutrition)
    }
}