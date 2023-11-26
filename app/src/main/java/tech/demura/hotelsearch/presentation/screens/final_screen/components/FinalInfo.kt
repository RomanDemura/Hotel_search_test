package tech.demura.hotelsearch.presentation.screens.final_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.demura.hotelsearch.R
import tech.demura.hotelsearch.presentation.views.texts.DescriptionText

@Composable
fun ColumnScope.FinalInfo() {
    Column(
        modifier = Modifier.weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // FINAL IMAGE
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.final_img),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        // FINAL TEXT
        Text(
            text = "Ваш заказ принят в работу",
            fontSize = 24.sp,
            fontWeight = FontWeight(500)
        )

        // FINAL DESCRIPTION
        DescriptionText(
            text = "Подтверждение заказа №104893 может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление.",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}