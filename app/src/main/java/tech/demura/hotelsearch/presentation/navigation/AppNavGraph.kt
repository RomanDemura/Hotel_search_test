package tech.demura.hotelsearch.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import tech.demura.hotelsearch.domain.entity.Hotel

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    hotelScreenContent: @Composable () -> Unit,
    roomsScreenContent: @Composable (hotelName: String) -> Unit,
    bookingScreenContent: @Composable () -> Unit,
    finalScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.MainScreen.route
    ) {
        MainScreenNavGraph(
            hotelScreenContent = hotelScreenContent,
            roomsScreenContent = roomsScreenContent,
            bookingScreenContent = bookingScreenContent,
            finalScreenContent = finalScreenContent,
        )
    }

}