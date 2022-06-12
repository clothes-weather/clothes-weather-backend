package com.cw.clothesweather.configs

import com.cw.clothesweather.security.RealmRoleConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
class ResourceServerConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests()
            .antMatchers("/api/v1/weather/metrics", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll().and()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt { jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()) }

        return http.build()
    }

    private fun jwtAuthenticationConverter(): Converter<Jwt, out AbstractAuthenticationToken> {
        val jwtConverter = JwtAuthenticationConverter()
        jwtConverter.setJwtGrantedAuthoritiesConverter(RealmRoleConverter())
        return jwtConverter
    }
}