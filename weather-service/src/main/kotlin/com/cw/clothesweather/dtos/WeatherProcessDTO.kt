package com.cw.clothesweather.dtos

import org.bson.types.ObjectId

data class WeatherDTO(
    val id: ObjectId,
    var name: String,
    var email: String,
    var password: String
)
