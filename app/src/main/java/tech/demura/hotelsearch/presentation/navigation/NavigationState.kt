package tech.demura.hotelsearch.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navHostController: NavHostController
) {
    // NAVIGATE TO ROUTE
    fun navigateTo(route: String) {
        navHostController.navigate(route = route) {
            launchSingleTop = true
        }
    }

    // NAVIGATE TO ROOMS SCREEN (WITH ARGS)
    fun navigateToRoomsScreen(hotelName: String) {
        navHostController.navigate(Screen.RoomsScreen.getRouteWithHotel(hotelName)) {
            launchSingleTop = true
        }
    }

    // NAVIGATE TO START, WITH POP UP TO START
    fun popUpToStart() {
        navHostController.navigate(Screen.HotelScreen.route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}

// REMEMBER NAV STATE
@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}