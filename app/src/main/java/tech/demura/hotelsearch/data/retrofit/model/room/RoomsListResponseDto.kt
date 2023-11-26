package tech.demura.hotelsearch.data.retrofit.model.room

import com.google.gson.annotations.SerializedName

data class RoomsListResponseDto(
    @SerializedName("rooms") val rooms: List<RoomResponseDto>,
)
