package com.cw.apigateway.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class Controller {

    @GetMapping("/")
    fun index(principal: Principal): String? {
        return principal.name
    }
}