package tech.demura.hotelsearch.presentation.screens.hotel_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.R
import tech.demura.hotelsearch.presentation.views.DetailListItem

@Composable
fun Details() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {

        // УДОБСТВА
        DetailListItem(
            iconId = R.drawable.emoji_happy,
            headlineText = "Удобства"
        )
        Divider()

        // ЧТО ВКЛЮЧЕНО
        DetailListItem(
            iconId = R.drawable.tick_square,
            headlineText = "Что включено"
        )
        Divider()

        // ЧТО НЕ ВКЛЮЧЕНО
        DetailListItem(
            iconId = R.drawable.close_square,
            headlineText = "Что не включено"
        )
    }
}