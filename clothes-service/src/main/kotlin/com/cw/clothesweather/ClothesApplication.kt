package com.cw.clothesweather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class ClothesServiceApplication

fun main(args: Array<String>) {
    runApplication<ClothesServiceApplication>(*args)
}
