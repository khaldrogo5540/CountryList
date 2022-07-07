package com.example.countrylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrylist.data.MyCountryItem
import com.example.countrylist.databinding.ActivityMainBinding
import com.example.countrylist.presentation.ui.CountryAdapter
import com.example.countrylist.presentation.ui.UiState
import com.example.countrylist.presentation.ui.viewmodel.CountryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val countryViewModel: CountryViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val countryAdapter: CountryAdapter by lazy {
        CountryAdapter(emptyList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeScreenUpdate()
        initViews()
    }

    private fun initViews() {
        binding.countryRecycler.adapter = countryAdapter
        binding.countryRecycler.layoutManager = LinearLayoutManager(this)
    }

    private fun observeScreenUpdate() {
        countryViewModel.myCountry.observe(this){
            when (it){
                is UiState.Response -> { updateAdapter(it.data) }
                is UiState.Error -> { displayError(it.errorMessage) }
            }
        }
    }

    private fun displayError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    private fun updateAdapter(data: List<MyCountryItem>) {
        countryAdapter.setCountryList(data)
    }
}