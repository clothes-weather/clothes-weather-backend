package com.cw.clothesweather.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "clothes_weather_collection")
data class Weather(
    @Id
    val id: ObjectId,
    var temperature: Double,
    var feelsTemperature: Double
) {
    constructor(temperature: Double, feelsTemperature: Double) : this(ObjectId.get(), temperature, feelsTemperature)
}
