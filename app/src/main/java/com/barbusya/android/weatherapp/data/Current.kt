package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("temp_c")
    var temperature: Int = 0,
    @SerializedName("condition")
    var currentCondition: CurrentCondition? = null,
)

data class CurrentCondition(
    @SerializedName("text")
    var currentConditionText: String = "",

)