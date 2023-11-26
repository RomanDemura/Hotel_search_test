package tech.demura.hotelsearch.presentation.screens.hotel_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.demura.hotelsearch.domain.entity.Hotel
import tech.demura.hotelsearch.presentation.views.TagsRow

@Composable
fun AboutTheHotel(hotel: Hotel) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Об отеле",
            fontSize = 24.sp,
            fontWeight = FontWeight(500)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TagsRow(tags = hotel.peculiarities)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = hotel.description,
            fontSize = 16.sp,
            fontWeight = FontWeight(400)
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}