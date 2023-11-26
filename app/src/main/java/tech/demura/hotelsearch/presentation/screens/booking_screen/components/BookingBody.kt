package tech.demura.hotelsearch.presentation.screens.booking_screen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.domain.entity.Tourist
import tech.demura.hotelsearch.presentation.screens.booking_screen.BookingScreenViewModel
import tech.demura.hotelsearch.presentation.views.buttons.ThemedButton

@Composable
fun BookingBody(
    paddingValue: PaddingValues,
    bookingInfo: BookingInfo,
    viewModel: BookingScreenViewModel,
    onButtonClick: () -> Unit


) {
    val touristLiveData = viewModel.touristLiveData.observeAsState(listOf<Tourist>())
    var isPhoneValid by rememberSaveable { mutableStateOf(false) }
    var isEmailValid by rememberSaveable { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .padding(paddingValue)
            .padding(bottom = 16.dp)
    ) {
        item {

            // FOOTER HOTEL INFO
            HotelInfoCard(bookingInfo = bookingInfo)
            Spacer(modifier = Modifier.height(16.dp))

            // TRAVEL INFO
            TravelInfoCard(bookingInfo)
            Spacer(modifier = Modifier.height(16.dp))

            // BUYER INFO
            BuyerInfoCard(
                isPhoneValid = { isPhoneValid = it },
                isEmailValid = { isEmailValid = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // TOURIST LIST
        items(
            items = touristLiveData.value
        ) {
            TouristCard(
                tourist = it,
                isTouristChanged = { viewModel.updateTourist(it) }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {

            // ADD TOURIST
            AddTouristCard {
                viewModel.addTourist()
            }
            Spacer(modifier = Modifier.height(16.dp))

            // PRICE INFO
            PriceInfoCard(bookingInfo = bookingInfo)
            Spacer(modifier = Modifier.height(16.dp))

            // BUTTON PAY
            ThemedButton(
                text = "Оплатить",
                onClick = {
                    if (viewModel.validation(isPhoneValid, isEmailValid)) {
                        onButtonClick()
                    }
                }
            )
        }
    }
}