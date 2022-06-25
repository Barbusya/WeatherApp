package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Forecast (
    @SerializedName("forecastday")
    val forecastDays: List<ForecastDays>? = null
)

data class ForecastDays(
    @SerializedName("date_epoch")
    val date: Int = 0,
    @SerializedName("day")
    val day: Day? = null,
    @SerializedName("hour")
    val hours: List<Hours>? = null,
)

data class Day (
    @SerializedName("maxtemp_c")
    val maxTempC: Float = 0f,
    @SerializedName("mintemp_c")
    val minTempC: Float = 0f,
)

data class Hours(
    @SerializedName("time_epoch")
    val hoursTime: Float = 0f,
    @SerializedName("temp_c")
    val hoursTempC: Float = 0f,
)
