package com.cw.clothesweather.controllers

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/api/v1/clothes")
@Tag(name = "ПОГОДНЫЙ API V1")
class ClothesController {

    @GetMapping("/test-auth")
    @RolesAllowed("user")
    fun testAuth(principal: Principal): String {
        return "test auth, User Id: ${principal.name}"
    }
}