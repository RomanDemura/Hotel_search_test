package tech.demura.hotelsearch.presentation.screens.hotel_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.demura.hotelsearch.domain.entity.Hotel
import tech.demura.hotelsearch.extensions.toPriceString
import tech.demura.hotelsearch.presentation.views.FooterHotelInfo
import tech.demura.hotelsearch.presentation.views.Pager


@Composable
fun HotelInfo(hotel: Hotel) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        // PAGER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Pager(urls = hotel.image_urls)
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // FOOTER
        FooterHotelInfo(
            name = hotel.name,
            rating = hotel.rating,
            ratingName = hotel.rating_name,
            address = hotel.adress,
        )
        Spacer(modifier = Modifier.height(8.dp))

        // PRICE
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "от ${hotel.minimal_price.toPriceString()}",
                fontSize = 30.sp,
                fontWeight = FontWeight(600)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = hotel.price_for_it,
                fontSize = 16.sp,
                fontWeight = FontWeight(400)
            )
        }
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