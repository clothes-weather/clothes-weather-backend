package com.cw.clothesweather.controllers

import com.cw.clothesweather.dtos.WeatherDTO
import com.cw.clothesweather.dtos.WeatherProcessDTO
import com.cw.clothesweather.services.WeatherService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.security.Principal
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/api/v1/weather")
@Tag(name = "ПОГОДНЫЙ API V1")
class WeatherController(
    private val weatherService: WeatherService
) {

    @GetMapping("/metrics")
    fun weatherMetrics(@RequestParam(defaultValue = "Москва") city: String): WeatherDTO? {
        return weatherService.getWeatherMetrics(city)
    }

    @PostMapping("/process-metrics")
    @RolesAllowed("user")
    fun saveWeatherProcess(@RequestParam(defaultValue = "Москва") city: String): WeatherProcessDTO {
        return weatherService.saveWeatherMetrics(city)
    }

    @GetMapping("/test-auth")
    @RolesAllowed("user")
    fun testAuth(principal: Principal): String {
        return "test auth, User Id: ${principal.name}"
    }
}