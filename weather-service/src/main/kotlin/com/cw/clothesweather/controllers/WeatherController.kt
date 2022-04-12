package com.cw.clothesweather.controllers

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/api/v1/weather")
@Tag(name = "Контроллер для погоды")
class WeatherController() {

    //    @GetMapping("/{id}")
//    fun getUserInfo(@PathVariable id: ObjectId): ResponseEntity<User> {
//
//    }
    @GetMapping
    @RolesAllowed("test")
    fun test(): String {
        return "test"
    }

    @GetMapping("/test-auth")
    @RolesAllowed("weather_read")
    fun testAuth(principal: Principal): String {
        return "test auth, User Id: ${principal.name}"
    }
}