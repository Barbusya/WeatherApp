package com.barbusya.android.weatherapp.networkapi

import com.barbusya.android.weatherapp.data.Current
import com.barbusya.android.weatherapp.data.Forecast
import com.barbusya.android.weatherapp.data.Location
import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("location")
    val location: Location? = null
    @SerializedName("current")
    val current: Current? = null
    @SerializedName("forecast")
    var forecast: Forecast? = null

}
