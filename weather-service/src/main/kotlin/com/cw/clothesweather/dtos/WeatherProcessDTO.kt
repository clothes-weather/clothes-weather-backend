package com.cw.clothesweather.dtos

import com.cw.clothesweather.models.Weather
import com.cw.clothesweather.models.enums.WeatherSource
import org.bson.types.ObjectId

data class WeatherProcessDTO(
    val id: ObjectId,
    var period: String,
    var source: WeatherSource,
    var value: Weather?
)
