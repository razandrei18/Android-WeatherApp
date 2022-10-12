package com.project.weatherapp.repository

import com.project.weatherapp.api.ApiService
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val apiService: ApiService) {

    suspend fun getWeather () = apiService.getWeatherForCity()
}