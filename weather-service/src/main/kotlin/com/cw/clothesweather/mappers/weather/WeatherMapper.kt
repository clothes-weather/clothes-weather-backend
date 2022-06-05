package com.cw.clothesweather.mappers.weather

import com.cw.clothesweather.models.Weather
import com.cw.clothesweather.dtos.WeatherDTO

interface WeatherMapper<R> {
    fun mapResponseWeatherToModel(responseWeather: R): Weather
    fun mapResponseWeatherToDTO(responseWeather: R): WeatherDTO
}