package tech.demura.hotelsearch.presentation.screens.rooms_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import tech.demura.hotelsearch.domain.entity.RoomScreenState
import tech.demura.hotelsearch.domain.use_case.GetRoomStateFlowUseCase
import javax.inject.Inject

class RoomsScreenViewModel @Inject constructor(
    private val getRoomStateFlowUseCase: GetRoomStateFlowUseCase
) : ViewModel() {

    // ROOM LIST FLOW
    private val roomListFlow = getRoomStateFlowUseCase()
    val roomsListState = roomListFlow
        .filter { it.isNotEmpty() }
        .map { RoomScreenState.RoomsInfo(rooms = it) }
        .onStart { RoomScreenState.Loading }
}