package com.example.countrylist.di

import com.example.countrylist.data.ApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideRetrofit(
        baseUrl: String,
        jsonConverter: Converter.Factory
    ) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverter)
        .build()

    @Provides
    fun provideBaseUrl() = "https://gist.githubusercontent.com/"

    @Provides
    fun provideJsonConverterFactory(): Converter.Factory = GsonConverterFactory.create()
}