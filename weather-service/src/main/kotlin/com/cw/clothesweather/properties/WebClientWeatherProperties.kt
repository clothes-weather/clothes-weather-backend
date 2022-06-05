package com.cw.clothesweather.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "webclient.weather")
@ConstructorBinding
data class WebClientWeatherProperties(
    val openweather: Openweather
)

data class Openweather(
    val url: String,
    val appId: String
)