package tech.demura.hotelsearch.presentation.screens.booking_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.demura.hotelsearch.domain.entity.BookingScreenState
import tech.demura.hotelsearch.domain.entity.Tourist
import tech.demura.hotelsearch.presentation.ViewModelFactory
import tech.demura.hotelsearch.presentation.screens.booking_screen.components.AddTouristRow
import tech.demura.hotelsearch.presentation.screens.booking_screen.components.BuyerInfo
import tech.demura.hotelsearch.presentation.screens.booking_screen.components.PriceInfo
import tech.demura.hotelsearch.presentation.screens.booking_screen.components.TouristCard
import tech.demura.hotelsearch.presentation.screens.booking_screen.components.TravelInfo
import tech.demura.hotelsearch.presentation.views.FooterHotelInfo

@ExperimentalMaterial3Api
@Composable
fun BookingScreen(
    vmFactory: ViewModelFactory,
    onButtonClick: () -> Unit,
    onBackPressed: () -> Unit
) {
    val viewModel: BookingScreenViewModel = viewModel(factory = vmFactory)
    val bookingScreenState =
        viewModel.bookingInfoState.collectAsState(initial = BookingScreenState.Initial)
    val currentState = bookingScreenState.value
    val touristLiveData = viewModel.touristLiveData.observeAsState(listOf<Tourist>())
    var isPhoneValid by rememberSaveable { mutableStateOf(false) }
    var isEmailValid by rememberSaveable { mutableStateOf(false) }

    BackHandler {
        onBackPressed()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Бронирование")
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValue ->
        when (currentState) {
            is BookingScreenState.Info -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValue)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    item {
                        val bookingInfo = currentState.bookingInfo
                        // FOOTER HOTEL INFO
                        FooterHotelInfo(
                            name = bookingInfo.hotel_name,
                            rating = bookingInfo.horating,
                            ratingName = bookingInfo.rating_name,
                            address = bookingInfo.hotel_adress
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        // TRAVEL INFO
                        TravelInfo(bookingInfo)
                        Spacer(modifier = Modifier.height(16.dp))

                        // BUYER INFO
                        BuyerInfo(
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
                        AddTouristRow {
                            viewModel.addTourist()
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        // PRICE INFO
                        PriceInfo(bookingInfo = currentState.bookingInfo)
                        Spacer(modifier = Modifier.height(16.dp))

                        // BUTTON PAY
                        Button(
                            onClick = {
                                if (viewModel.validation(isPhoneValid, isEmailValid)) {
                                    onButtonClick()
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF0D72FF)
                            )
                        ) {
                            Text(
                                text = "Оплатить",
                                fontSize = 16.sp,
                                fontWeight = FontWeight(500)
                            )
                        }
                    }
                }
            }

            else -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValue)
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

