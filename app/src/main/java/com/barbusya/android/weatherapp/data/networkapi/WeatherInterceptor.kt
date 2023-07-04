package com.barbusya.android.weatherapp.data.networkapi

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val API_KEY = "971bcc646b804390ba3105555220401 "

class WeatherInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()

        val newUrl: HttpUrl = originalRequest.url().newBuilder()
            .addQueryParameter("key", API_KEY)
            .addQueryParameter("days", "5")
            .addQueryParameter("aqi", "no")
            .addQueryParameter("alerts", "no")
            .build()

        val newRequest: Request = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}