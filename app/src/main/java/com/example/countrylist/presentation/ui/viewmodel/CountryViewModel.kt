package com.example.countrylist.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrylist.presentation.ui.UiState
import com.example.countrylist.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CountryViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    private val _myCountry = MutableLiveData<UiState>()
    val myCountry:LiveData<UiState>
    get() = _myCountry

    init {
        viewModelScope.launch{
            repository.getCountryData().collect{
                _myCountry.value = it
            }
        }
    }
}