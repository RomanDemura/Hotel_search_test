package tech.demura.hotelsearch.domain.entity

import com.google.gson.annotations.SerializedName

data class Room(
    val id: Int,
    val name: String,
    val price: Int,
    val price_per: String,
    val peculiarities: List<String>,
    val image_urls: List<String>,
)