package tech.demura.hotelsearch.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.demura.hotelsearch.presentation.views.chips.RatingChip

@Composable
fun FooterHotelInfo(
    name: String,
    rating: Int,
    ratingName: String,
    address: String
) {
    // RATING
    RatingChip(rating = rating, ratingName = ratingName)
    Spacer(modifier = Modifier.height(4.dp))

    // NAME
    Text(
        text = name,
        fontSize = 24.sp,
        fontWeight = FontWeight(500)
    )
    Spacer(modifier = Modifier.height(8.dp))

    // ADDRESS
    Text(
        modifier = Modifier.clickable {  },
        color = Color.Blue,
        text = address,
        fontSize = 14.sp,
        fontWeight = FontWeight(500)
    )
}