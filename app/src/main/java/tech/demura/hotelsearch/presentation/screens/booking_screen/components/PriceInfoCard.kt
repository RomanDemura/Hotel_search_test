package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.extensions.toPriceString
import tech.demura.hotelsearch.presentation.views.ThemedCard
import tech.demura.hotelsearch.presentation.views.rows.PricePairRow

@Composable
fun PriceInfoCard(bookingInfo: BookingInfo) {
    ThemedCard {
        // TOUR
        PricePairRow(
            leftText = "Тур",
            rightText = bookingInfo.tour_price.toPriceString()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // FUEL CHARGE
        PricePairRow(
            leftText = "Топливный сбор",
            rightText = bookingInfo.fuel_charge.toPriceString()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // SERVICE CHARGE
        PricePairRow(
            leftText = "Сервисный сбор",
            rightText = bookingInfo.service_charge.toPriceString()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // TOTAL AMOUNT
        PricePairRow(
            leftText = "К оплате",
            rightText = bookingInfo.finalPrice.toPriceString(),
            isFinalPrice = true
        )
    }
}