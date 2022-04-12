package com.cw.apigateway.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        http
            .authorizeExchange()
            .pathMatchers("/actuator/**")
            .permitAll()
            .and()
            .authorizeExchange()
            .anyExchange()
            .authenticated()
            .and()
            .oauth2Login()

        return http.build()
    }
}