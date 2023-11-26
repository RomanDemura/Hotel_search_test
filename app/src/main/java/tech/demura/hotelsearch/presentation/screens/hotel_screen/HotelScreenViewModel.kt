package tech.demura.hotelsearch.presentation.screens.hotel_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import tech.demura.hotelsearch.domain.entity.HotelScreenState
import tech.demura.hotelsearch.domain.use_case.GetHotelStateFlowUseCase
import javax.inject.Inject

class HotelScreenViewModel @Inject constructor(
    private val getHotelListUseCase: GetHotelStateFlowUseCase
) : ViewModel() {

    // HOTEL LIST FLOW
    private val hotelListFlow = getHotelListUseCase()

    val hotelListState = hotelListFlow
        .filter { it.isNotEmpty() }
        .map { HotelScreenState.HotelsInfo(hotelsInfo = it) }
        .onStart { HotelScreenState.Loading }

}