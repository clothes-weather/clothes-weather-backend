package com.cw.clothesweather.models

import com.cw.clothesweather.models.enums.WeatherSource
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "clothes_weather_collection")
data class WeatherProcess(
    @Id
    val id: ObjectId,
    var period: String,
    var source: WeatherSource,
    var value: Weather?
) {
    constructor(period: String, source: WeatherSource, value: Weather?): this(ObjectId.get(), period, source, value)
}