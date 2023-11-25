package tech.demura.hotelsearch

import android.app.Application
import tech.demura.hotelsearch.di.ApplicationComponent
import tech.demura.hotelsearch.di.DaggerApplicationComponent

class HotelSearchApplication: Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}