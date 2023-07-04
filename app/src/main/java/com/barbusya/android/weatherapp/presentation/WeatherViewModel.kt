package com.barbusya.android.weatherapp.presentation

import android.app.Application
import androidx.lifecycle.*
import com.barbusya.android.weatherapp.data.QueryPreferences
import com.barbusya.android.weatherapp.data.networkapi.WeatherFetcher

class WeatherViewModel(private val app: Application) : AndroidViewModel(app) {

    val weatherItemLiveData: LiveData<MutableList<String>>

    private val weatherFetcher = WeatherFetcher()
    private val mutableSearchTerm = MutableLiveData<String>()

    val searchTerm: String
        get() = mutableSearchTerm.value ?: ""

    init {
        mutableSearchTerm.value = QueryPreferences.getStoreQuery(app)

        weatherItemLiveData =
            Transformations.switchMap(mutableSearchTerm) {searchTerm ->
                if(searchTerm.isBlank()){
                    weatherFetcher.fetchWeather()
                } else {
                    weatherFetcher.searchWeather(searchTerm)
                }
            }
    }

    fun fetchWeather(query: String = "") {
        QueryPreferences.setStoredQuery(app, query)
        mutableSearchTerm.value = query
    }
}