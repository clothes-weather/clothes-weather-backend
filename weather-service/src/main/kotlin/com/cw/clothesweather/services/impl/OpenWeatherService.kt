package com.cw.clothesweather.services.impl

import com.cw.clothesweather.dtos.WeatherDTO
import com.cw.clothesweather.dtos.WeatherProcessDTO
import com.cw.clothesweather.dtos.response.OpenWeatherResponse
import com.cw.clothesweather.mappers.impl.WeatherProcessMapper
import com.cw.clothesweather.mappers.weather.WeatherMapper
import com.cw.clothesweather.models.WeatherProcess
import com.cw.clothesweather.models.enums.WeatherSource
import com.cw.clothesweather.properties.WebClientWeatherProperties
import com.cw.clothesweather.repositories.WeatherProcessRepository
import com.cw.clothesweather.services.WeatherService
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class OpenWeatherService(
    private val webClient: WebClient,
    private val weatherProcessRepository: WeatherProcessRepository,
    private val openWeatherProperties: WebClientWeatherProperties,
    private val openWeatherMapper: WeatherMapper<OpenWeatherResponse>,
    private val weatherProcessMapper: WeatherProcessMapper
) : WeatherService {

    override fun getWeatherMetrics(city: String): WeatherDTO? {

        return collectWeatherMetricsFromApi(city)?.let { openWeatherMapper.mapResponseWeatherToDTO(it) }
    }

    override fun saveWeatherMetrics(city: String): WeatherProcessDTO {
        val weatherProcess = WeatherProcess("day", WeatherSource.OPEN_WEATHER,
            collectWeatherMetricsFromApi(city)?.let { openWeatherMapper.mapResponseWeatherToModel(it) })

        weatherProcessRepository.save(weatherProcess)

        return weatherProcessMapper.fromModel(weatherProcess)
    }

    private fun collectWeatherMetricsFromApi(city: String): OpenWeatherResponse? {
        return webClient.get()
            .uri(openWeatherProperties.openweather.url) { uri -> uri.queryParam("q", city).build() }
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono<OpenWeatherResponse>()
            .block()
    }
}