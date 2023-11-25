package tech.demura.hotelsearch.presentation.navigation

import com.google.gson.Gson
import tech.demura.hotelsearch.domain.entity.Hotel
import tech.demura.hotelsearch.extensions.encode

sealed class Screen(
    val route: String
){
    object MainScreen: Screen(ROUTE_MAIN_SCREEN)

    object HotelScreen: Screen(ROUTE_HOTEL_SCREEN)

    object RoomsScreen: Screen(ROUTE_ROOMS_SCREEN){
        private const val ROUTE_FOR_ARGS = "rooms_screen"
        fun getRouteWithHotel(hotelName: String): String{
            val hotelNameJson = Gson().toJson(hotelName)
            return "$ROUTE_FOR_ARGS/${hotelNameJson.encode()}"
        }
    }

    object BookingScreen: Screen(ROUTE_BOOKING_SCREEN)

    object FinalScreen: Screen(ROUTE_FINAL_SCREEN)

    companion object{
        const val KEY_HOTEL = "hotel"

        const val ROUTE_MAIN_SCREEN = "main_screen"
        const val ROUTE_HOTEL_SCREEN = "hotel_screen"
        const val ROUTE_ROOMS_SCREEN = "rooms_screen/{$KEY_HOTEL}"
        const val ROUTE_BOOKING_SCREEN = "booking_screen"
        const val ROUTE_FINAL_SCREEN = "final_screen"
    }
}
