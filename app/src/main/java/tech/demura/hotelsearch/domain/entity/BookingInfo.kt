package tech.demura.hotelsearch.domain.entity

import com.google.gson.annotations.SerializedName

data class BookingInfo(
    val id: Int = 0,
    val hotel_name: String = "",
    val hotel_adress: String = "",
    val horating: Int = 0,
    val rating_name: String = "",
    val departure: String = "",
    val arrival_country: String = "",
    val tour_date_start: String = "",
    val tour_date_stop: String = "",
    val number_of_nights: Int = 0,
    val room: String = "",
    val nutrition: String = "",
    val tour_price: Int = 0,
    val fuel_charge: Int = 0,
    val service_charge: Int = 0,
    val finalPrice: Int = tour_price + fuel_charge + service_charge
)
