package tech.demura.hotelsearch.data.retrofit.mapper

import tech.demura.hotelsearch.data.retrofit.model.room.RoomResponseDto
import tech.demura.hotelsearch.data.retrofit.model.room.RoomsListResponseDto
import tech.demura.hotelsearch.domain.entity.Room
import javax.inject.Inject

class RoomMapper @Inject constructor() {

    // MAP MODEL LIST TO ENTITY LIST
    fun mapListRoomModelToListRoom(response: RoomsListResponseDto): List<Room> {
        return response.rooms.map {
            mapRoomModelToRoom(it)
        }
    }

    // MAP MODEL TO ENTITY
    fun mapRoomModelToRoom(model: RoomResponseDto): Room {
        return Room(
            id = model.id,
            name = model.name,
            price = model.price,
            price_per = model.price_per,
            peculiarities = model.peculiarities,
            image_urls = model.image_urls
        )
    }
}