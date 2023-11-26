package tech.demura.hotelsearch.presentation.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailListItem(
    iconId: Int,
    headlineText: String,
    supportingText: String = "Самое необходимое"
) {
    ListItem(
        leadingContent = {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = null
            )
        },
        headlineText = {
            Text(
                text = headlineText,
                fontSize = 16.sp,
                fontWeight = FontWeight(500)
            )
        },
        supportingText = {
            Text(
                text = supportingText,
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