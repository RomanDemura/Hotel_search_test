package tech.demura.hotelsearch.data.retrofit.network

import retrofit2.http.GET
import tech.demura.hotelsearch.data.retrofit.model.booking.BookingInfoDto
import tech.demura.hotelsearch.data.retrofit.model.hotel.HotelResponseDto
import tech.demura.hotelsearch.data.retrofit.model.room.RoomsListResponseDto

interface ApiService {

    // GET HOTEL
    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotelInfo(): HotelResponseDto

    // GET ROOM LIST
    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRoomList(): RoomsListResponseDto

    // GET BOOKING INFO
    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getBookingInfo(): BookingInfoDto
}


// https://run.mocky.io/v3/d144777c-a67f-4e35-867a-cacc3b827473 // HOTEL
// https://run.mocky.io/v3/8b532701-709e-4194-a41c-1a903af00195 // ROOM LIST
// https://run.mocky.io/v3/63866c74-d593-432c-af8e-f279d1a8d2ff // BOOKING INFO