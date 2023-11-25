package tech.demura.hotelsearch.presentation.screens.rooms_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import tech.demura.hotelsearch.domain.entity.RoomScreenState
import tech.demura.hotelsearch.domain.use_case.GetHotelStateFlowUseCase
import tech.demura.hotelsearch.domain.use_case.GetRoomStateFlowUseCase
import tech.demura.hotelsearch.domain.use_case.LoadNextRoomUseCase
import tech.demura.hotelsearch.extensions.mergeWith
import javax.inject.Inject

class RoomsScreenViewModel @Inject constructor(
    val getRoomStateFlowUseCase: GetRoomStateFlowUseCase,
    val getHotelStateFlowUseCase: GetHotelStateFlowUseCase,
    val loadNextRoomUseCase: LoadNextRoomUseCase
) :ViewModel() {
    private val exceptionHandler = CoroutineExceptionHandler{ _, _ ->
        Log.d("RoomsScreenViewModel", "Caught exception by ExceptionHandler")
    }

    // Rooms list flow
    private val loadedNextRoomEvent = MutableSharedFlow<Unit>()
    private val roomListFlow = getRoomStateFlowUseCase()
    private val loadNextRoomFlow = flow {
        loadedNextRoomEvent.collect {
            emit(
                RoomScreenState.RoomsInfo(
                    rooms = roomListFlow.value,
                    isLoading = true
                )
            )
        }
    }
    val roomsListState = roomListFlow
        .filter { it.isNotEmpty() }
        .map { RoomScreenState.RoomsInfo(rooms = it) }
        .onStart { RoomScreenState.Loading }
        .mergeWith(loadNextRoomFlow)

    val hotelListState = getHotelStateFlowUseCase()
        .filter { it.isNotEmpty() }
        .map { it.first().name }


    fun loadNextData(){
        viewModelScope.launch(exceptionHandler){
            loadedNextRoomEvent.emit(Unit)
            loadNextRoomUseCase()
        }
    }
}