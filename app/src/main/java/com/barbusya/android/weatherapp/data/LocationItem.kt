package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class LocationItem(
    @SerializedName("name")
    var city: String = "",
    @SerializedName("localtime")
    var localTime: String = "",
)