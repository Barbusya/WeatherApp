package com.barbusya.android.weatherapp.networkapi

import com.barbusya.android.weatherapp.data.CurrentItem
import com.barbusya.android.weatherapp.data.LocationItem
import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("location")
    lateinit var locationItem: LocationItem
    @SerializedName("current")
    lateinit var currentItem: CurrentItem
}