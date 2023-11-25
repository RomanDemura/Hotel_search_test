package tech.demura.hotelsearch.presentation.screens.hotel_screen

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
import tech.demura.hotelsearch.domain.entity.HotelScreenState
import tech.demura.hotelsearch.domain.use_case.GetHotelStateFlowUseCase
import tech.demura.hotelsearch.domain.use_case.LoadNextHotelUseCase
import tech.demura.hotelsearch.extensions.mergeWith
import javax.inject.Inject

class HotelScreenViewModel @Inject constructor(
    private val getHotelListUseCase: GetHotelStateFlowUseCase,
    private val loadNextHotelUseCase: LoadNextHotelUseCase
) : ViewModel() {
    private val exceptionHandler = CoroutineExceptionHandler{ _, _ ->
        Log.d("HotelScreenViewModel", "Caught exception by ExceptionHandler")
    }

    // Hotel list flow
    private val loadedNextHotelEvent = MutableSharedFlow<Unit>()
    private val hotelListFlow = getHotelListUseCase()
    private val loadNextHotelFlow = flow {
        loadedNextHotelEvent.collect {
            emit(
                HotelScreenState.HotelsInfo(
                    hotelsInfo = hotelListFlow.value,
                    isLoading = true
                )
            )
        }
    }
    val hotelListState = hotelListFlow
        .filter { it.isNotEmpty() }
        .map { HotelScreenState.HotelsInfo(hotelsInfo = it) }
        .onStart { HotelScreenState.Loading }
        .mergeWith(loadNextHotelFlow)

    fun loadNextData(){
        viewModelScope.launch(exceptionHandler){
            loadedNextHotelEvent.emit(Unit)
            loadNextHotelUseCase()
        }
    }



}