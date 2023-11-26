package tech.demura.hotelsearch.presentation.screens.hotel_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.demura.hotelsearch.domain.entity.HotelScreenState
import tech.demura.hotelsearch.presentation.ViewModelFactory
import tech.demura.hotelsearch.presentation.screens.hotel_screen.components.HotelCard

@ExperimentalMaterial3Api
@Composable
fun HotelScreen(
    vmFactory: ViewModelFactory,
    onButtonClick: (hotelName: String) -> Unit
) {
    val viewModel: HotelScreenViewModel = viewModel(factory = vmFactory)
    val state = viewModel.hotelListState.collectAsState(initial = HotelScreenState.Initial)
    val currentState = state.value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Отель") }
            )
        }
    ) {

        when (currentState) {
            is HotelScreenState.HotelsInfo -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(it)
                        .padding(bottom = 16.dp)
                ) {
                    items(
                        items = currentState.hotelsInfo,
                    ) {
                        HotelCard(
                            hotel = it,
                            onButtonClick = onButtonClick
                        )
                    }
                }
            }

            else -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(150.dp)
                            .align(Alignment.Center)
                    )
                }

            }
        }
    }
}


