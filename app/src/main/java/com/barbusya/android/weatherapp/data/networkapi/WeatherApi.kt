package com.barbusya.android.weatherapp.data.networkapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast.json?")
    fun fetchWeather(@Query("q") query: String): Call<WeatherResponse>

    @GET("v1/forecast.json?")
    fun searchWeather(@Query("q") query: String): Call<WeatherResponse>
}