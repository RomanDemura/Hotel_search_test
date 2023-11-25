package tech.demura.hotelsearch.data.retrofit.model.hotel

import com.google.gson.annotations.SerializedName

data class AboutTheHotelDto(
    @SerializedName("description") val description: String,
    @SerializedName("peculiarities") val peculiarities: List<String>,
)