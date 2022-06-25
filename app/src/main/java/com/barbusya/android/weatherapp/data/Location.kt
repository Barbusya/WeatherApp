package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val city: String = "",
    @SerializedName("localtime_epoch")
    val localTime: Int = 0,
)