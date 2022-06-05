package com.cw.clothesweather.controllers

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/v1/weather")
class SwaggerController(@Value("\${springdoc.swagger-ui.servers.weather-service}") private val weatherServiceUrl: String) {
    @GetMapping("/swagger")
    fun greeting(): String {
        return "redirect:$weatherServiceUrl/swagger-ui/index.html";
    }
}