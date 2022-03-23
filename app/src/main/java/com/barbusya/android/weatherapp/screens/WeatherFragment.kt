package com.barbusya.android.weatherapp.screens

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.barbusya.android.weatherapp.R
import com.barbusya.android.weatherapp.model.WeatherViewModel
import com.barbusya.android.weatherapp.databinding.FragmentWeatherBinding

private const val TAG = "WeatherFragment"

class WeatherFragment: Fragment(R.layout.fragment_weather) {

    private val binding by viewBinding(FragmentWeatherBinding::bind)

    private val weatherViewModel: WeatherViewModel by lazy {
        ViewModelProvider(this).get(WeatherViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherViewModel.weatherItemLiveData.observe(
            viewLifecycleOwner) { weatherItem ->
            binding.location.text = weatherItem[0]
            binding.data.text = weatherItem[1]
            binding.temp.text = weatherItem[2]
            binding.weatherDescription.text = weatherItem[3]
//            binding.maxTemp.text = weatherItem[4]
//            binding.minTemp.text = weatherItem[5]
            }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_wether_app, menu)

        val searchItem: MenuItem = menu.findItem(R.id.menu_item_search)
        val searchView = searchItem.actionView as SearchView

        searchView.apply {

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(queryText: String): Boolean {
                    Log.d(TAG, "QueryTextSubmit: $queryText")
                    weatherViewModel.fetchWeather(queryText)
                    return true
                }

                override fun onQueryTextChange(queryText: String): Boolean {
                    Log.d(TAG, "QueryTextChange: $queryText")
                    return false
                }
            })

            setOnSearchClickListener {
                searchView.setQuery(weatherViewModel.searchTerm, false)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_item_clear -> {
                weatherViewModel.fetchWeather("")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}