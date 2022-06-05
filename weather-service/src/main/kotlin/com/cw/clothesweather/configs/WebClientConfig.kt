package com.cw.clothesweather.configs

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import java.util.concurrent.TimeUnit

@Configuration
class WebClientConfig {

    private companion object val DEFAULT_TIMEOUT: Int = 10000

    @Bean
    fun webClientWithTimeout(): WebClient {
        val httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, DEFAULT_TIMEOUT)
            .doOnConnected { connection ->
                connection.addHandlerLast(ReadTimeoutHandler(DEFAULT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS))
                    .addHandlerLast(WriteTimeoutHandler(DEFAULT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS))
            }

        return WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .build()
    }
}