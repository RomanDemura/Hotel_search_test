package tech.demura.hotelsearch.presentation.screens.hotel_screen

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.demura.hotelsearch.domain.entity.HotelScreenState
import tech.demura.hotelsearch.presentation.ViewModelFactory
import tech.demura.hotelsearch.presentation.screens.hotel_screen.components.HotelScreenBody
import tech.demura.hotelsearch.presentation.views.LoadingBox

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
            HotelScreenTopBar()
        }
    ) { paddingValues ->

        when (currentState) {
            is HotelScreenState.HotelsInfo -> {
                HotelScreenBody(
                    paddingValues = paddingValues,
                    hotelList = currentState.hotelsInfo,
                    onButtonClick = onButtonClick
                )
            }

            else -> {
                LoadingBox()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HotelScreenTopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Отель") }
    )
}

