package tech.demura.hotelsearch.presentation.views.texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SmallDescriptionText(
    text: String
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight(400)
    )
}
