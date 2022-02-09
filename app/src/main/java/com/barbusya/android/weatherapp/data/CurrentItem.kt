package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class CurrentItem(
    @SerializedName("temp_c")
    var temperature: Float = 0f,
)
