package tech.demura.hotelsearch.presentation.views.chips

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreInfoChip() {
    AssistChip(
        onClick = {  },
        label = {
            Text(
                text = "Подробнее о номере",
                fontSize = 16.sp
            )
        },
        trailingIcon = { Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null) },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = Color(0x1A0D72FF),
            labelColor = Color(0xFF0D72FF),
            trailingIconContentColor = Color(0xFF0D72FF)
        ),
        border = null
    )
}

