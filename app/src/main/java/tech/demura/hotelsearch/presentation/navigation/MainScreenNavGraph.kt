package tech.demura.hotelsearch.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation

fun NavGraphBuilder.MainScreenNavGraph(
    hotelScreenContent: @Composable () -> Unit,
    roomsScreenContent: @Composable (hotelName: String) -> Unit,
    bookingScreenContent: @Composable () -> Unit,
    finalScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = Screen.HotelScreen.route,
        route = Screen.MainScreen.route

    ) {

        // HOTEL SCREEN DESTINATION
        composable(Screen.HotelScreen.route) {
            hotelScreenContent()
        }

        // ROOMS SCREEN DESTINATION
        composable(route = Screen.RoomsScreen.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_HOTEL) {
                    type = NavType.StringType
                }
            )
        ) {
            val hotelName = it.arguments?.getString(Screen.KEY_HOTEL) ?: "Hotel rooms"
            roomsScreenContent(hotelName)
        }

        // BOOKING SCREEN DESTINATION
        composable(route = Screen.BookingScreen.route) {
            bookingScreenContent()
        }

        // FINAL SCREEN DESTINATION
        composable(route = Screen.FinalScreen.route) {
            finalScreenContent()
        }
    }
}