package com.barbusya.android.weatherapp.networkapi

import com.barbusya.android.weatherapp.data.Current
//import com.barbusya.android.weatherapp.data.Forecast
import com.barbusya.android.weatherapp.data.Location
import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("location")
    var location: Location? = null
    @SerializedName("current")
    var current: Current? = null
//    @SerializedName("forecast")
//    var forecast: Forecast? = null

}
