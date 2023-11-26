package tech.demura.hotelsearch.presentation.views.texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun DescriptionText(
    text: String,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        textAlign = textAlign
    )
}