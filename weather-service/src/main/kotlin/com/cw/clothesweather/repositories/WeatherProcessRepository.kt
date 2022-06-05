package com.cw.clothesweather.repositories

import com.cw.clothesweather.models.WeatherProcess
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface WeatherProcessRepository: MongoRepository<WeatherProcess, ObjectId> {
}