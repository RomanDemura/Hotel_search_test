package tech.demura.hotelsearch.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tech.demura.hotelsearch.presentation.screens.booking_screen.BookingScreenViewModel
import tech.demura.hotelsearch.presentation.screens.hotel_screen.HotelScreenViewModel
import tech.demura.hotelsearch.presentation.screens.rooms_screen.RoomsScreenViewModel

//@ApplicationScope
@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(HotelScreenViewModel::class)
    @Binds
    fun bindHotelScreenViewModel(viewModel: HotelScreenViewModel): ViewModel

    @IntoMap
    @ViewModelKey(RoomsScreenViewModel::class)
    @Binds
    fun bindRoomScreenViewModel(viewModel: RoomsScreenViewModel): ViewModel

    @IntoMap
    @ViewModelKey(BookingScreenViewModel::class)
    @Binds
    fun bindBookingScreenViewModel(viewModel: BookingScreenViewModel): ViewModel
}