package com.cw.clothesweather.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Weather(
    @Id
    val id: ObjectId = ObjectId.get(),
    var name: String,
    var email: String,
    var password: String
)