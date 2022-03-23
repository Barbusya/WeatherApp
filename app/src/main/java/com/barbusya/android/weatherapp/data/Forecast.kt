package com.barbusya.android.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Forecast (
    @SerializedName("forecastday")
    var forecastDays: List<ForecastDays>? = null
)

data class ForecastDays(
    @SerializedName("date_epoch")
    var date: Int = 0,
    @SerializedName("day")
    var days: Days? = null,
    @SerializedName("hour")
    var hours: List<Hours>? = null,
)

data class Days (
    @SerializedName("maxtemp_c")
    var maxTempC: Int = 0,
    @SerializedName("mintemp_c")
    var minTempC: Int = 0,
)

data class Hours(
    @SerializedName("time_epoch")
    var hoursTime: Int = 0,
    @SerializedName("temp_c")
    var hoursTempC: Int = 0,
)
