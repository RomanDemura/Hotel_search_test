package tech.demura.hotelsearch.presentation.screens.booking_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import tech.demura.hotelsearch.domain.entity.BookingScreenState
import tech.demura.hotelsearch.domain.entity.Tourist
import tech.demura.hotelsearch.domain.use_case.GetBookingInfoStateFlowUseCase
import javax.inject.Inject

class BookingScreenViewModel @Inject constructor(
    private val getBookingInfoStateFlowUseCase: GetBookingInfoStateFlowUseCase
) : ViewModel() {

    // BOOKING INFO FLOW
    val bookingInfoState = getBookingInfoStateFlowUseCase()
        .map { BookingScreenState.Info(bookingInfo = it) }
        .onStart { BookingScreenState.Loading }

    // TOURIST LIST CONTAINER
    private var autoincrement = 0

    private val _touristList = mutableListOf<Tourist>(
        Tourist(id = ++autoincrement, isCollapsed = false)
    )
    private val touristList: List<Tourist>
        get() = _touristList.toList()

    // TOURIST LIST LIVE DATA
    private val _touristLiveData = MutableLiveData<List<Tourist>>()
    val touristLiveData: LiveData<List<Tourist>>
        get() = _touristLiveData

    init {
        updateLiveData()
    }
    private fun updateLiveData() {
        _touristLiveData.value = _touristList.sortedBy { it.id }
    }

    // ADD TOURIST
    fun addTourist() {
        _touristList.add(Tourist(id = ++autoincrement))
        updateLiveData()
    }

    // UPDATE TOURIST
    fun updateTourist(newTourist: Tourist) {
        val oldTourist = _touristList.find { it.id == newTourist.id }
            ?: throw RuntimeException("Tourist did not find")
        _touristList.remove(oldTourist)
        _touristList.add(newTourist)
        updateLiveData()
    }

    // VALIDATION ALL PARAMETERS
    fun validation(isPhoneValid: Boolean, isEmailValid: Boolean): Boolean =
        isPhoneValid && isEmailValid && isTouristListValid()

    // VALIDATION TOURIST LIST
    private fun isTouristListValid(): Boolean {
        touristList.forEach {
            if (!isTouristValid(it))
                return false
        }
        return true
    }

    // VALIDATION TOURIST
    private fun isTouristValid(tourist: Tourist): Boolean =
        tourist.isNameValid &&
                tourist.isLastNameValid &&
                tourist.isDateOfBirthValid &&
                tourist.isCitizenshipValid &&
                tourist.isInternationalPassportValid &&
                tourist.isValidityPeriodOfThePassportValid

}