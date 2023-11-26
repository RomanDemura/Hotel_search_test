package tech.demura.hotelsearch.data.retrofit.model.booking

import com.google.gson.annotations.SerializedName

data class BookingInfoDto(
    @SerializedName("id") val id: Int,
    @SerializedName("hotel_name") val hotel_name: String,
    @SerializedName("hotel_adress") val hotel_adress: String,
    @SerializedName("horating") val horating: Int,
    @SerializedName("rating_name") val rating_name: String,
    @SerializedName("departure") val departure: String,
    @SerializedName("arrival_country") val arrival_country: String,
    @SerializedName("tour_date_start") val tour_date_start: String,
    @SerializedName("tour_date_stop") val tour_date_stop: String,
    @SerializedName("number_of_nights") val number_of_nights: Int,
    @SerializedName("room") val room: String,
    @SerializedName("nutrition") val nutrition: String,
    @SerializedName("tour_price") val tour_price: Int,
    @SerializedName("fuel_charge") val fuel_charge: Int,
    @SerializedName("service_charge") val service_charge: Int,
)

