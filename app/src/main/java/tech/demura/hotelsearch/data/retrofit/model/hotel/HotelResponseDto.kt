package tech.demura.hotelsearch.data.retrofit.model.hotel

import com.google.gson.annotations.SerializedName

data class HotelResponseDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("adress") val adress: String,
    @SerializedName("minimal_price") val minimal_price: Int,
    @SerializedName("price_for_it") val price_for_it: String,
    @SerializedName("rating") val rating: Int,
    @SerializedName("rating_name") val rating_name: String,
    @SerializedName("image_urls") val image_urls: List<String>,
    @SerializedName("about_the_hotel") val about_the_hotel: AboutTheHotelDto,
)