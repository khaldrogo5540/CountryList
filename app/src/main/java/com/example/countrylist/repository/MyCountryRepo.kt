package com.example.countrylist.repository

import com.example.countrylist.data.*
import com.example.countrylist.presentation.ui.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class MyCountryRepo @Inject constructor(private val service: ApiService) : Repository {

override fun getCountryData(): Flow<UiState> {
        return if (isConnected) {

            flow {
                val response = service.countryInformation()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(UiState.Response(it))
                    }
                } else {
                    emit(UiState.Error(response.message()))
                }
            }
        } else
            flowOf(UiState.Error("No network connection"))
    }

}