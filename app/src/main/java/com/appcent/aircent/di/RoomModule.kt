package com.appcent.aircent.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {
    //TODO: aşağıdaki fonksiyon tamamlanacak + providerDao fonksiyonları eklenecek

//    @Provides
//    @Singleton
//    fun provideAppDataBase(application: Application): AppDataBase {
//        return Room
//            .databaseBuilder(application, AppDataBase::class.java, "database.db")
//            .fallbackToDestructiveMigration()
//            .allowMainThreadQueries()
//            .build()
//    }
}