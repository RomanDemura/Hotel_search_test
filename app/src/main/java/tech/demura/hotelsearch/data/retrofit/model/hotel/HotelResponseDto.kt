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

//{
//    "id": 1, Int
//    "name": "Лучший пятизвездочный отель в Хургаде, Египет", String
//    "adress": "Madinat Makadi, Safaga Road, Makadi Bay, Египет", String
//    "minimal_price": 134268, Int
//    "price_for_it": "За тур с перелётом", String
//    "rating": 5, Int
//    "rating_name": "Превосходно", String
//    "image_urls": ["https://www.atorus.ru/sites/default/files/upload/image/News/56149/Club_Priv%C3%A9_by_Belek_Club_House.jpg", "https://deluxe.voyage/useruploads/articles/The_Makadi_Spa_Hotel_02.jpg", "https://deluxe.voyage/useruploads/articles/article_1eb0a64d00.jpg"],
//    "about_the_hotel":
//    {
//        "description": "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
//        "peculiarities": ["Бесплатный Wifi на всей территории отеля", "1 км до пляжа", "Бесплатный фитнес-клуб", "20 км до аэропорта"]
//
//    }
//}