package tech.demura.hotelsearch.presentation.screens.rooms_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.demura.hotelsearch.domain.entity.RoomScreenState
import tech.demura.hotelsearch.extensions.removeQuotes
import tech.demura.hotelsearch.presentation.ViewModelFactory
import tech.demura.hotelsearch.presentation.screens.rooms_screen.components.RoomsScreenBody
import tech.demura.hotelsearch.presentation.views.LoadingBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomsScreen(
    vmFactory: ViewModelFactory,
    hotelName: String,
    onButtonClick: () -> Unit,
    onBackPressed: () -> Unit
) {
    val viewModel: RoomsScreenViewModel = viewModel(factory = vmFactory)
    val state = viewModel.roomsListState.collectAsState(initial = RoomScreenState.Initial)
    val currentState = state.value

    BackHandler {
        onBackPressed()
    }

    Scaffold(
        topBar = {
            RoomsScreenTopBar(
                hotelName = hotelName,
                onBackPressed = onBackPressed
            )
        }
    ) { paddingValues ->
        when (currentState) {
            is RoomScreenState.RoomsInfo -> {
                RoomsScreenBody(
                    paddingValues = paddingValues,
                    roomList = currentState.rooms,
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
private fun RoomsScreenTopBar(
    hotelName: String,
    onBackPressed: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = hotelName.removeQuotes(),
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { onBackPressed() }
            ) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft, contentDescription = null
                )
            }
        }
    )
}