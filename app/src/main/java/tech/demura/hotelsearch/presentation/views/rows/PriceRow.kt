package tech.demura.hotelsearch.presentation.views.rows

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun PriceRow(
    price: String,
    pricePer: String
) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = price,
            fontSize = 32.sp,
            fontWeight = FontWeight(600)
        )
        Text(
            text = pricePer,
            fontSize = 16.sp,
            fontWeight = FontWeight(400)
        )
    }
}