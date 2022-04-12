package com.cw.clothesweather.configs

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.GroupedOpenApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig(@Value("\${springdoc.swagger-ui.servers.weather-service}") private val weatherServiceUrl: String) {

    @Bean
    fun api(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("weather-api")
            .pathsToMatch("/public/**")
            .build()
    }

    @Bean
    fun apiInfo(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Weather REST API")
                    .description("Информационная система \"погодный ассистент\" погодный микросервис")
                    .version("v1")
                    .contact(
                        Contact()
                            .name("Nikita Lvov")
                            .email("n.lvov58@gmail.com")
                            .url("https://t.me/nikitecc")
                    )
            )
            .servers(mutableListOf(Server().description("weather-service").url(weatherServiceUrl)))
    }
}