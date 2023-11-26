package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.demura.hotelsearch.presentation.views.ThemedCard
import tech.demura.hotelsearch.presentation.views.buttons.SmallButtonWithIcon
import tech.demura.hotelsearch.presentation.views.rows.ThemedRow
import tech.demura.hotelsearch.presentation.views.texts.HeaderText

@Composable
fun AddTouristCard(
    addTourist: () -> Unit
) {
    ThemedCard {
        ThemedRow {

            // ADD TOURIST TEXT
            HeaderText(
                text = "Добавить туриста",
                modifier = Modifier.weight(1f)
            )

            // ADD TOURIST BUTTON
            SmallButtonWithIcon(
                imageVector = Icons.Filled.Add,
                onClick = addTourist
            )
        }
    }

}