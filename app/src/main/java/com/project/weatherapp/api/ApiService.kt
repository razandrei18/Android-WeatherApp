package com.project.weatherapp.api

import com.project.weatherapp.models.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/Bucharest")
    suspend fun getWeatherForCity(): Response<Weather>
}