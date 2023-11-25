package tech.demura.hotelsearch.presentation.views.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingChip(rating: Int, ratingName: String){
    AssistChip(
        onClick = { /*TODO*/ },
        label = {
            Text(
                text = ratingName,
                fontSize = 16.sp,
                fontWeight = FontWeight(500)
            )
        },
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )
                Text(
                    text = rating.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500)
                )
            }

        },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = Color(0x33FFC700),
            labelColor = Color(0xFFFFA800),
            leadingIconContentColor = Color(0xFFFFA800)
        ),
        border = null
    )
}