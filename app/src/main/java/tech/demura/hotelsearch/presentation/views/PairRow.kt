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
fun PairRow(
    leftText: String,
    rightText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            modifier = Modifier.weight(2f),
            text = leftText,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF828796)
        )
        Text(
            modifier = Modifier.weight(3f),
            text = rightText,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF000000)
        )
    }
}