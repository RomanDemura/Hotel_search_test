package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.presentation.views.PairRow

@Composable
fun TravelInfo(bookingInfo: BookingInfo) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // DEPARTURE
        PairRow(
            leftText = "Вылет из",
            rightText = bookingInfo.departure
        )

        // ARRIVAL COUNTRY
        PairRow(
            leftText = "Страна, город",
            rightText = bookingInfo.arrival_country
        )

        // DATES RANGE
        PairRow(
            leftText = "Даты",
            rightText = "${bookingInfo.tour_date_start} - ${bookingInfo.tour_date_stop}"
        )

        // NUMBER OF NIGHTS
        PairRow(
            leftText = "Кол-во ночей",
            rightText = "${bookingInfo.number_of_nights} ночей"
        )

        // HOTEL NAME
        PairRow(
            leftText = "Отель",
            rightText = bookingInfo.hotel_name
        )

        // ROOM NAME
        PairRow(
            leftText = "Номер",
            rightText = bookingInfo.room
        )
        
        // NUTRIATION
        PairRow(
            leftText = "Питание",
            rightText = bookingInfo.nutrition
        )
    }
}