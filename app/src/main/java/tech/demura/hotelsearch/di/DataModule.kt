package tech.demura.hotelsearch.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import tech.demura.hotelsearch.data.repository.BookingRepositoryImpl
import tech.demura.hotelsearch.data.repository.HotelRepositoryImpl
import tech.demura.hotelsearch.data.repository.RoomRepositoryImpl
import tech.demura.hotelsearch.data.retrofit.network.ApiFactory
import tech.demura.hotelsearch.data.retrofit.network.ApiService
import tech.demura.hotelsearch.domain.repository.BookingRepository
import tech.demura.hotelsearch.domain.repository.HotelRepository
import tech.demura.hotelsearch.domain.repository.RoomRepository

@Module
interface DataModule {

    // bind HOTEL repository
    @ApplicationScope
    @Binds
    fun bindHotelRepository(impl: HotelRepositoryImpl): HotelRepository

    // bind ROOM repository
    @ApplicationScope
    @Binds
    fun bindRoomRepository(impl: RoomRepositoryImpl): RoomRepository

    // bind BOOKING repository
    @ApplicationScope
    @Binds
    fun bindBookingRepository(impl: BookingRepositoryImpl): BookingRepository

    companion object {

        // provide API SERVICE
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}