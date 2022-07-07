package com.example.countrylist.di

import com.example.countrylist.data.ApiService
import com.example.countrylist.repository.MyCountryRepo
import com.example.countrylist.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun providesRepository(service: ApiService): Repository = MyCountryRepo(service)
}
