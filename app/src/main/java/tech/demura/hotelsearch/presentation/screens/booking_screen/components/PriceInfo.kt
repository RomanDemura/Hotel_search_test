package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.extensions.toPriceString
import tech.demura.hotelsearch.presentation.views.PricePairRow

@Composable
fun PriceInfo(bookingInfo: BookingInfo){
    Column {
        PricePairRow(leftText = "Тур", rightText = bookingInfo.tour_price.toPriceString(), isFinalPrice = false)
        Spacer(modifier = Modifier.height(8.dp))
        PricePairRow(leftText = "Топливный сбор", rightText = bookingInfo.fuel_charge.toPriceString(), isFinalPrice = false)
        Spacer(modifier = Modifier.height(8.dp))
        PricePairRow(leftText = "Сервисный сбор", rightText = bookingInfo.service_charge.toPriceString(), isFinalPrice = false)
        Spacer(modifier = Modifier.height(8.dp))
        PricePairRow(leftText = "К оплате", rightText = bookingInfo.finalPrice.toPriceString(), isFinalPrice = true)
    }
}