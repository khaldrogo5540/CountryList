package com.example.countrylist.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrylist.data.MyCountryItem
import com.example.countrylist.databinding.CountryInfoItemBinding

class CountryAdapter(private var countryList: List<MyCountryItem>) :
    RecyclerView.Adapter<CountryAdapter.CountriesViewHolder>() {

    fun setCountryList(newList: List<MyCountryItem>){
        countryList = newList
        notifyDataSetChanged()
    }

    class CountriesViewHolder(private val binding: CountryInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(countryItem: MyCountryItem) {
            binding.countryNameTv.text = String.format(countryItem.name + ",")
            binding.countryRegionTv.text = countryItem.region
            binding.codeTv.text = countryItem.code
            binding.capital.text = countryItem.capital

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CountriesViewHolder(
            CountryInfoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.onBind(countryList[position])
    }

    override fun getItemCount() = countryList.size

}