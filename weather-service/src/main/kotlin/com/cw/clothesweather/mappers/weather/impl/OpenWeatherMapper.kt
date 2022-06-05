package com.cw.clothesweather.mappers.weather.impl

import com.cw.clothesweather.dtos.WeatherDTO
import com.cw.clothesweather.dtos.response.OpenWeatherResponse
import com.cw.clothesweather.mappers.weather.WeatherMapper
import com.cw.clothesweather.models.Weather
import org.springframework.stereotype.Component

@Component
class OpenWeatherMapper : WeatherMapper<OpenWeatherResponse> {
    override fun mapResponseWeatherToModel(responseWeather: OpenWeatherResponse): Weather {
        return Weather(
            responseWeather.main.temp,
            responseWeather.main.feelsLike
        )
    }

    override fun mapResponseWeatherToDTO(responseWeather: OpenWeatherResponse): WeatherDTO {
        return WeatherDTO(
            responseWeather.main.temp,
            responseWeather.main.feelsLike
        )
    }
}