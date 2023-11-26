package tech.demura.hotelsearch.presentation.screens.hotel_screen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.demura.hotelsearch.domain.entity.Hotel
import tech.demura.hotelsearch.extensions.toPriceString
import tech.demura.hotelsearch.presentation.views.FooterHotelInfo
import tech.demura.hotelsearch.presentation.views.Pager
import tech.demura.hotelsearch.presentation.views.ThemedCard
import tech.demura.hotelsearch.presentation.views.rows.PriceRow

@Composable
fun HotelInfoCard(hotel: Hotel) {
    ThemedCard {
        // PAGER
        Pager(urls = hotel.image_urls)
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // FOOTER HOTEL INFO
        FooterHotelInfo(
            name = hotel.name,
            rating = hotel.rating,
            ratingName = hotel.rating_name,
            address = hotel.adress,
        )
        Spacer(modifier = Modifier.height(8.dp))

        // PRICE
        PriceRow(
            price = "от ${hotel.minimal_price.toPriceString()}",
            pricePer = hotel.price_for_it
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}


//@Preview
//@Composable
//fun HotelInfoPreview() {
//    val hotel = Hotel(
//        id = 1,
//        name = "Лучший пятизвездочный отель в Хургаде, Египет",
//        adress = "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
//        minimal_price = 134268,
//        price_for_it = "За тур с перелётом",
//        rating = 5,
//        rating_name = "Превосходно",
//        image_urls = listOf(
//            "https://www.atorus.ru/sites/default/files/upload/image/News/56149/Club_Priv%C3%A9_by_Belek_Club_House.jpg",
//            "https://deluxe.voyage/useruploads/articles/The_Makadi_Spa_Hotel_02.jpg",
//            "https://deluxe.voyage/useruploads/articles/article_1eb0a64d00.jpg"
//        ),
//        description = "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
//        peculiarities = listOf(
//            "Бесплатный Wifi на всей территории отеля",
//            "1 км до пляжа",
//            "Бесплатный фитнес-клуб",
//            "20 км до аэропорта"
//        )
//    )
//    Column(
//        modifier = Modifier.verticalScroll(rememberScrollState())
//    ) {
//        HotelInfo(hotel = hotel)
//        AboutTheHotel(hotel = hotel)
//    }
//}