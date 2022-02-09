package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class WeatherItem(
    var location: String,
    var localTime: String,
    var currentTemperature: String,
)
