package com.appcent.aircent.di

import com.appcent.aircent.data.remote.airlines.AirlineService
import com.appcent.aircent.utils.mConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(mConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideAirlineService(retrofit: Retrofit): AirlineService{
        return retrofit.create(AirlineService::class.java)
    }

    //TODO: kalan provideService fonksiyonları eklenecek
}