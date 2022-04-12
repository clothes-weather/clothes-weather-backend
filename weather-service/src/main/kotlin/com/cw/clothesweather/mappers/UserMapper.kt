package com.cw.clothesweather.mappers

import com.cw.clothesweather.dtos.UserDTO
import com.cw.clothesweather.models.User

class UserMapper : Mapper<UserDTO, User> {

    override fun fromEntity(entity: User): UserDTO {
        return UserDTO(
            entity.id,
            entity.name,
            entity.email,
            entity.password
        )
    }

    override fun toEntity(domain: UserDTO): User {
        return User(
            domain.id,
            domain.name,
            domain.email,
            domain.password
        )
    }
}