package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    var city: String = "",
    @SerializedName("localtime_epoch")
    var localTime: Int = 0,
)