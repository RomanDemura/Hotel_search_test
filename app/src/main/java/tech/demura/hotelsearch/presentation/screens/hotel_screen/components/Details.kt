package tech.demura.hotelsearch.presentation.screens.hotel_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.demura.hotelsearch.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        // УДОБСТВА
        ListItem(
            leadingContent = {
                Icon(
                    painter = painterResource(id = R.drawable.emoji_happy),
                    contentDescription = null
                )
            },
            headlineText = {
                Text(
                    text = "Удобства",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500)
                )
            },
            supportingText = {
                Text(
                    text = "Самое необходимое",
                    fontSize = 14.sp,
                )
            },
            trailingContent = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
                }
            }
        )
        Divider()

        // ЧТО ВКЛЮЧЕНО
        ListItem(
            leadingContent = {
                Icon(
                    painter = painterResource(id = R.drawable.tick_square),
                    contentDescription = null
                )
            },
            headlineText = {
                Text(
                    text = "Что включено",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500)
                )
            },
            supportingText = {
                Text(
                    text = "Самое необходимое",
                    fontSize = 14.sp,
                )
            },
            trailingContent = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
                }
            }
        )
        Divider()

        // ЧТО НЕ ВКЛЮЧЕНО
        ListItem(
            leadingContent = {
                Icon(
                    painter = painterResource(id = R.drawable.close_square),
                    contentDescription = null
                )
            },
            headlineText = {
                Text(
                    text = "Что не включено",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500)
                )
            },
            supportingText = {
                Text(
                    text = "Самое необходимое",
                    fontSize = 14.sp,
                )
            },
            trailingContent = {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
                }
            }
        )
    }
}