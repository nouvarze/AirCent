package com.appcent.aircent.di

import com.appcent.aircent.data.remote.airlines.AirlineService
import com.appcent.aircent.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    //TODO: provideRepository fonksiyonları eklenecek

    @Provides
    @Singleton
    fun provideRepository(airlineService: AirlineService): Repository{
        return Repository(airlineService)
    }
//    @Singleton
//    @Provides
//    fun provideRepository(
//        api: AirlineService
//    ){
//
//    }
}