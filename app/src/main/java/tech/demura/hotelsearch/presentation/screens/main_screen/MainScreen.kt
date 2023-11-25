package tech.demura.hotelsearch.presentation.screens.main_screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import tech.demura.hotelsearch.presentation.ViewModelFactory
import tech.demura.hotelsearch.presentation.screens.booking_screen.BookingScreen
import tech.demura.hotelsearch.presentation.screens.final_screen.FinalScreen
import tech.demura.hotelsearch.presentation.screens.hotel_screen.HotelScreen
import tech.demura.hotelsearch.presentation.navigation.AppNavGraph
import tech.demura.hotelsearch.presentation.navigation.Screen
import tech.demura.hotelsearch.presentation.navigation.rememberNavigationState
import tech.demura.hotelsearch.presentation.screens.rooms_screen.RoomsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    vmFactory: ViewModelFactory
) {
    val navigationState = rememberNavigationState()

    AppNavGraph(
        navHostController = navigationState.navHostController,
        hotelScreenContent = {
            HotelScreen(
                vmFactory = vmFactory,
                onButtonClick = { hotelName ->
                    navigationState.navigateToRoomsScreen(hotelName)
                }
            )
        },
        roomsScreenContent = { hotelName ->
            RoomsScreen(
                vmFactory = vmFactory,
                hotelName = hotelName,
                onBackPressed = {
                    navigationState.navHostController.popBackStack()
                },
                onButtonClick = {
                    navigationState.navigateTo(Screen.BookingScreen.route)
                }
            )
        },
        bookingScreenContent = {
            BookingScreen(
                vmFactory = vmFactory,
                onBackPressed = {
                    navigationState.navHostController.popBackStack()
                },
                onButtonClick = {
                    navigationState.navigateTo(Screen.FinalScreen.route)
                }
            )
        },
        finalScreenContent = {
            FinalScreen(
                onBackPressed = {
                    navigationState.popUpToStart()
                },
                onButtonClick = {
                    navigationState.popUpToStart()
                }
            )
        }
    )
}