package tech.demura.hotelsearch.domain.entity

import tech.demura.hotelsearch.data.retrofit.model.hotel.AboutTheHotelDto

data class Hotel(
    val id: Int = 0,
    val name: String = "",
    val adress: String = "",
    val minimal_price: Int = 0,
    val price_for_it: String = "",
    val rating: Int = 0,
    val rating_name: String = "",
    val image_urls: List<String> = listOf(),
    val description: String = "",
    val peculiarities: List<String> = listOf(),
)