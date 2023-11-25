package tech.demura.hotelsearch.data.retrofit.mapper

import tech.demura.hotelsearch.data.retrofit.model.booking.BookingInfoDto
import tech.demura.hotelsearch.data.retrofit.model.hotel.HotelResponseDto
import tech.demura.hotelsearch.domain.entity.BookingInfo
import tech.demura.hotelsearch.domain.entity.Hotel
import javax.inject.Inject

class BookingInfoMapper @Inject constructor() {
    fun mapBookingInfoModelToBookingInfo(model: BookingInfoDto): BookingInfo {
        return BookingInfo(
        id = model.id,
        hotel_name = model.hotel_name,
        hotel_adress = model.hotel_adress,
        horating = model.horating,
        rating_name = model.rating_name,
        departure = model.departure,
        arrival_country = model.arrival_country,
        tour_date_start = model.tour_date_start,
        tour_date_stop = model.tour_date_stop,
        number_of_nights = model.number_of_nights,
        room = model.room,
        nutrition = model.nutrition,
        tour_price = model.tour_price,
        fuel_charge = model.fuel_charge,
        service_charge = model.service_charge,
        )
    }
}