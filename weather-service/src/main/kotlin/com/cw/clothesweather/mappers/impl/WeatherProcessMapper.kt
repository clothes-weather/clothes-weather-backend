package com.cw.clothesweather.mappers

import com.cw.clothesweather.models.WeatherProcess
import com.cw.clothesweather.dtos.WeatherProcessDTO

interface WeatherProcessMapper {
    fun mapToDTO(model: WeatherProcess?): WeatherProcessDTO?
    fun mapToModel(dto: WeatherProcessDTO?): WeatherProcess?
}