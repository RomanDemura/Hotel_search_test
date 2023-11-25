package tech.demura.hotelsearch.data.retrofit.model.room

import com.google.gson.annotations.SerializedName

data class RoomResponseDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Int,
    @SerializedName("price_per") val price_per: String,
    @SerializedName("peculiarities") val peculiarities: List<String>,
    @SerializedName("image_urls") val image_urls: List<String>,
)