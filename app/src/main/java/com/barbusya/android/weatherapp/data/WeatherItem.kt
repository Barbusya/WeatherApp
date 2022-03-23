package com.barbusya.android.weatherapp.data


data class WeatherItem(
    var location: String,
    var localTime: String,
    var currentTemperature: String,
    var currentConditionText: String,
    var maxTemp: String,
    var minTemp: String,
)
