package com.cw.clothesweather.mappers.impl

import com.cw.clothesweather.dtos.WeatherProcessDTO
import com.cw.clothesweather.mappers.ModelMapper
import com.cw.clothesweather.models.WeatherProcess
import org.springframework.stereotype.Component

@Component
class WeatherProcessMapper : ModelMapper<WeatherProcessDTO, WeatherProcess> {
    override fun fromModel(entity: WeatherProcess): WeatherProcessDTO {
        return WeatherProcessDTO(
            entity.id,
            entity.period,
            entity.source,
            entity.value
        )
    }

    override fun toModel(domain: WeatherProcessDTO): WeatherProcess {
        TODO("Not yet implemented")
    }
}