package tech.demura.hotelsearch.presentation.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PricePairRow(
    leftText: String,
    rightText: String,
    isFinalPrice: Boolean
){
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = leftText,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF828796)
        )
        Text(
            text = rightText,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = if (isFinalPrice) Color(0xFF0D72FF) else Color(0xFF000000)
        )
    }
}