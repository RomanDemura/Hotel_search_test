package tech.demura.hotelsearch.data.retrofit.mapper

import tech.demura.hotelsearch.data.retrofit.model.hotel.HotelResponseDto
import tech.demura.hotelsearch.domain.entity.Hotel
import javax.inject.Inject

class HotelMapper @Inject constructor() {
    fun mapHotelModelToHotel(model: HotelResponseDto): Hotel {
        return Hotel(
            id = model.id,
            name = model.name,
            adress = model.adress,
            minimal_price = model.minimal_price,
            price_for_it = model.price_for_it,
            rating = model.rating,
            rating_name = model.rating_name,
            image_urls = model.image_urls,
            description = model.about_the_hotel.description,
            peculiarities = model.about_the_hotel.peculiarities,
        )
    }
}