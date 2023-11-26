package tech.demura.hotelsearch.presentation.screens.hotel_screen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.domain.entity.Hotel

@Composable
fun HotelScreenBody(
    paddingValues: PaddingValues,
    hotelList: List<Hotel>,
    onButtonClick: (hotelName: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(bottom = 16.dp)
    ) {
        items(
            items = hotelList,
        ) { hotel ->
            HotelInfoCard(hotel = hotel)

            Spacer(modifier = Modifier.height(16.dp))

            AboutTheHotelCard(
                hotel = hotel,
                onButtonClick = onButtonClick
            )
        }
    }


}


