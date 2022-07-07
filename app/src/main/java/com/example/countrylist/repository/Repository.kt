package com.example.countrylist.repository

import com.example.countrylist.presentation.ui.UiState
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getCountryData():Flow<UiState>
}