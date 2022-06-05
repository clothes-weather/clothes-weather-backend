package com.cw.clothesweather.services

import com.cw.clothesweather.dtos.WeatherDTO
import com.cw.clothesweather.dtos.WeatherProcessDTO

interface WeatherService {

    fun getWeatherMetrics(city: String): WeatherDTO?

    fun saveWeatherMetrics(city: String): WeatherProcessDTO

}