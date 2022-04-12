package com.cw.clothesweather.repositories

import com.cw.clothesweather.models.Weather
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface WeatherRepository: MongoRepository<Weather, ObjectId> {
}