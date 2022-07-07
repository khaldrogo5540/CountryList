package com.example.countrylist

import android.app.Application
import com.example.countrylist.data.NetworkConnectivity
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CountryApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        NetworkConnectivity(applicationContext)
    }
}