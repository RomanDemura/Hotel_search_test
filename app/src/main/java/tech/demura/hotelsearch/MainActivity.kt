package tech.demura.hotelsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import tech.demura.hotelsearch.presentation.ViewModelFactory
import tech.demura.hotelsearch.presentation.screens.main_screen.MainScreen
import tech.demura.hotelsearch.ui.theme.HotelSearchTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    // DAGGER APPLICATION COMPONENT
    private val component by lazy {
        (application as HotelSearchApplication).applicationComponent
    }

    // VIEW MODEL FACTORY
    @Inject
    lateinit var vmFactory: ViewModelFactory

    // ON CREATE
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