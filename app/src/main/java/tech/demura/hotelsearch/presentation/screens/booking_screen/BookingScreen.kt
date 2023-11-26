package tech.demura.hotelsearch.presentation.screens.booking_screen

import androidx.activity.compose.BackHandler
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.demura.hotelsearch.domain.entity.BookingScreenState
import tech.demura.hotelsearch.presentation.ViewModelFactory
import tech.demura.hotelsearch.presentation.screens.booking_screen.components.BookingBody
import tech.demura.hotelsearch.presentation.views.LoadingBox

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

    BackHandler {
        onBackPressed()
    }

    Scaffold(
        topBar = {
            BookingScreenTopBar(onBackPressed = { onBackPressed() })
        }
    ) { paddingValue ->
        when (currentState) {
            is BookingScreenState.Info -> {
                BookingBody(
                    paddingValue = paddingValue,
                    bookingInfo = currentState.bookingInfo,
                    viewModel = viewModel,
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
private fun BookingScreenTopBar(
    onBackPressed: () -> Unit
) {
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

