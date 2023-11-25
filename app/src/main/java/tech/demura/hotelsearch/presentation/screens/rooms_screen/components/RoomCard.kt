package tech.demura.hotelsearch.presentation.screens.rooms_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.demura.hotelsearch.domain.entity.Room
import tech.demura.hotelsearch.extensions.toPriceString
import tech.demura.hotelsearch.presentation.views.Pager
import tech.demura.hotelsearch.presentation.views.TagsRow
import tech.demura.hotelsearch.presentation.views.chips.MoreInfoChip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomCard(
    room: Room,
    onButtonClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // PAGER
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Pager(urls = room.image_urls)
            }
            Spacer(modifier = Modifier.height(8.dp))

            // ROOM NAME
            Text(
                text = room.name,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            // PECULARITIES
            TagsRow(tags = room.peculiarities)
            Spacer(modifier = Modifier.height(8.dp))

            // MORE INFO
            MoreInfoChip()
            Spacer(modifier = Modifier.height(8.dp))

            // PRICE
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = room.price.toPriceString(),
                    fontSize = 32.sp,
                    fontWeight = FontWeight(600)
                )
                Text(
                    text = room.price_per,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // BUTTON
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                onClick = { onButtonClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0D72FF)
                )
            ) {
                Text(
                    text = "Выбрать номер",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500)
                )
            }
        }
    }

}