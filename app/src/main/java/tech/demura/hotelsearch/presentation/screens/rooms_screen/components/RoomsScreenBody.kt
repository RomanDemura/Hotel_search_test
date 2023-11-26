package tech.demura.hotelsearch.presentation.screens.rooms_screen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.domain.entity.Room

@Composable
fun RoomsScreenBody(
    paddingValues: PaddingValues,
    roomList: List<Room>,
    onButtonClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(bottom = 16.dp)
    ) {
        items(
            items = roomList
        ) { room ->
            RoomCard(
                room = room,
                onButtonClick = onButtonClick
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}