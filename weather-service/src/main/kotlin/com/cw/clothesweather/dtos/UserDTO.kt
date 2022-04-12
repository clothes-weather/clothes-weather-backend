package com.cw.clothesweather.dtos

import org.bson.types.ObjectId

data class UserDTO(
    val id: ObjectId,
    var name: String,
    var email: String,
    var password: String
)
