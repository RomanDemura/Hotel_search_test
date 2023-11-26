package tech.demura.hotelsearch.presentation.screens.rooms_screen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.domain.entity.Room
import tech.demura.hotelsearch.extensions.toPriceString
import tech.demura.hotelsearch.presentation.views.Pager
import tech.demura.hotelsearch.presentation.views.ThemedCard
import tech.demura.hotelsearch.presentation.views.buttons.ThemedButton
import tech.demura.hotelsearch.presentation.views.chips.MoreInfoChip
import tech.demura.hotelsearch.presentation.views.rows.PriceRow
import tech.demura.hotelsearch.presentation.views.rows.TagsRow
import tech.demura.hotelsearch.presentation.views.texts.HeaderText

@Composable
fun RoomCard(
    room: Room,
    onButtonClick: () -> Unit
) {
    ThemedCard() {
        Spacer(modifier = Modifier.height(8.dp))

        // PAGER
        Pager(urls = room.image_urls)
        Spacer(modifier = Modifier.height(8.dp))

        // ROOM NAME
        HeaderText(text = room.name)
        Spacer(modifier = Modifier.height(8.dp))

        // PECULARITIES
        TagsRow(tags = room.peculiarities)
        Spacer(modifier = Modifier.height(8.dp))

        // MORE INFO
        MoreInfoChip()
        Spacer(modifier = Modifier.height(8.dp))

        // PRICE
        PriceRow(
            price = room.price.toPriceString(),
            pricePer = room.price_per
        )
        Spacer(modifier = Modifier.height(8.dp))

        // BUTTON
        ThemedButton(
            text = "Выбрать номер",
            onClick = onButtonClick
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

