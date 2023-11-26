package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.runtime.Composable
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.presentation.views.ThemedCard
import tech.demura.hotelsearch.presentation.views.rows.PairRow

@Composable
fun TravelInfoCard(bookingInfo: BookingInfo) {
    ThemedCard {

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