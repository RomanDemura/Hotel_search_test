package tech.demura.hotelsearch.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tech.demura.hotelsearch.MainActivity

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface ApplicationComponentFactory {

        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}