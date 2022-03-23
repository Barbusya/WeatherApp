package com.barbusya.android.weatherapp.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.barbusya.android.weatherapp.data.*
import com.barbusya.android.weatherapp.networkapi.WeatherApi
import com.barbusya.android.weatherapp.networkapi.WeatherInterceptor
import com.barbusya.android.weatherapp.networkapi.WeatherResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat

private const val TAG = "WeatherFetcher"

class WeatherFetcher {

    private val weatherApi: WeatherApi

    init {
        val client = OkHttpClient.Builder()
            .addInterceptor(WeatherInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        weatherApi = retrofit.create(WeatherApi::class.java)
    }

    fun fetchWeather():  LiveData<MutableList<String>>{
        return fetchWeatherMetadata(weatherApi.fetchWeather("Kazan"))
    }

    fun searchWeather(query: String):  LiveData<MutableList<String>>{
        return fetchWeatherMetadata(weatherApi.searchWeather(query))
    }

    fun getNormalDate(timeInMillies: Int?): String {
        val formatter = SimpleDateFormat("dd.MM.yyyy hh:mm")
        return formatter.format(timeInMillies?.toLong()?.times(1000))
    }

    private fun fetchWeatherMetadata(weatherRequest: Call<WeatherResponse>):
            LiveData<MutableList<String>> {
        val responseLiveData: MutableLiveData<MutableList<String>> = MutableLiveData()

        weatherRequest.enqueue(object  : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch weather", t)
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                Log.d(TAG, "Response received")
                val weatherResponse: WeatherResponse? = response.body()
                val location: Location? = weatherResponse?.location
                val current: Current? = weatherResponse?.current
                val forecast: Forecast? = weatherResponse?.forecast
                val currentCondition: CurrentCondition? = current?.currentCondition
                var forecastDays: List<ForecastDays> =
                    forecast?.forecastDays ?: mutableListOf()
                var days: Days? = forecastDays[0].days
                val weatherItem = WeatherItem(
                    location = location?.city.toString(),
                    localTime = getNormalDate(location?.localTime),
                    currentTemperature = current?.temperature.toString() + "°",
                    currentConditionText = currentCondition?.currentConditionText.toString(),
                    maxTemp = days?.maxTempC.toString() + "°",
                    minTemp = days?.minTempC.toString()  + "°",
                )
                responseLiveData.value = mutableListOf<String>(
                    weatherItem.component1(),
                    weatherItem.component2(),
                    weatherItem.component3(),
                    weatherItem.component4(),
                    weatherItem.component5(),
                    weatherItem.component6(),
                )
            }
        })

        return responseLiveData
    }

}