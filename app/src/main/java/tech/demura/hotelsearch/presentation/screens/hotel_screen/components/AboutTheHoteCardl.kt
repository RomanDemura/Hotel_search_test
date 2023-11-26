package tech.demura.hotelsearch.presentation.screens.hotel_screen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.domain.entity.Hotel
import tech.demura.hotelsearch.presentation.views.ThemedCard
import tech.demura.hotelsearch.presentation.views.buttons.ThemedButton
import tech.demura.hotelsearch.presentation.views.rows.TagsRow
import tech.demura.hotelsearch.presentation.views.texts.DescriptionText
import tech.demura.hotelsearch.presentation.views.texts.HeaderText

@Composable
fun AboutTheHotelCard(
    hotel: Hotel,
    onButtonClick: (String) -> Unit
) {
    ThemedCard {
        // HEADER TEXT
        HeaderText(text = "Об отеле")
        Spacer(modifier = Modifier.height(8.dp))

        // PECULIARITIES
        TagsRow(tags = hotel.peculiarities)
        Spacer(modifier = Modifier.height(8.dp))

        // DESCRIPTION
        DescriptionText(text = hotel.description)

        // DETAILS
        Details()
        Spacer(modifier = Modifier.height(4.dp))
        ThemedButton(
            text = "Выбрать отель",
            onClick = { onButtonClick(hotel.name) }
        )
    }
}