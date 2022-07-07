package com.example.countrylist.presentation.ui

import com.example.countrylist.data.MyCountryItem

sealed interface UiState{
    data class Response(val data: List<MyCountryItem>):UiState
    data class Error(val errorMessage:String):UiState
}