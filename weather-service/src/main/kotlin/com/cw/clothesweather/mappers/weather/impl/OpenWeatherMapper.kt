package com.cw.clothesweather.mappers.weather.impl

import com.cw.clothesweather.mappers.weather.WeatherMapper
import com.cw.clothesweather.dtos.response.OpenWeatherResponse
import com.cw.clothesweather.models.Weather
import com.cw.clothesweather.dtos.WeatherDTO

internal class OpenWeatherMapper : WeatherMapper<OpenWeatherResponse?> {
    override fun mapResponseWeatherToModel(responseWeather: OpenWeatherResponse): Weather {}
    override fun mapResponseWeatherToDTO(responseWeather: OpenWeatherResponse): WeatherDTO
}