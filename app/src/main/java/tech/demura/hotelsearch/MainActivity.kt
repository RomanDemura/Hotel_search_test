package tech.demura.hotelsearch

import android.app.StatusBarManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import tech.demura.hotelsearch.domain.entity.Tourist
import tech.demura.hotelsearch.presentation.ViewModelFactory
import tech.demura.hotelsearch.presentation.screens.booking_screen.BookingScreen
import tech.demura.hotelsearch.presentation.screens.booking_screen.components.BuyerInfo
import tech.demura.hotelsearch.presentation.screens.booking_screen.components.TouristCard
import tech.demura.hotelsearch.presentation.screens.final_screen.FinalScreen
import tech.demura.hotelsearch.presentation.screens.main_screen.MainScreen
import tech.demura.hotelsearch.ui.theme.HotelSearchTheme
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    private val component by lazy {
        (application as HotelSearchApplication).applicationComponent
    }

    @Inject
    lateinit var vmFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            HotelSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(vmFactory = vmFactory)
                }
            }
        }
    }
}