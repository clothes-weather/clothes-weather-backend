package com.cw.clothesweather.dtos.response

import com.fasterxml.jackson.annotation.JsonProperty

data class OpenWeatherResponse(

    @field:JsonProperty("visibility")
    val visibility: Int,

    @field:JsonProperty("timezone")
    val timezone: Int,

    @field:JsonProperty("main")
    val main: Main,

    @field:JsonProperty("clouds")
    val clouds: Clouds,

    @field:JsonProperty("sys")
    val sys: Sys,

    @field:JsonProperty("dt")
    val dt: Int,

    @field:JsonProperty("coord")
    val coord: Coord,

    @field:JsonProperty("weather")
    val weather: List<WeatherItem>,

    @field:JsonProperty("name")
    val name: String,

    @field:JsonProperty("cod")
    val cod: Int,

    @field:JsonProperty("base")
    val base: String,

    @field:JsonProperty("wind")
    val wind: Wind
)

data class WeatherItem(

    @field:JsonProperty("icon")
    val icon: String,

    @field:JsonProperty("description")
    val description: String,

    @field:JsonProperty("main")
    val main: String,
)

data class Coord(

    @field:JsonProperty("lon")
    val lon: Double,

    @field:JsonProperty("lat")
    val lat: Double
)

data class Main(

    @field:JsonProperty("temp")
    val temp: Double,

    @field:JsonProperty("temp_min")
    val tempMin: Double,

    @field:JsonProperty("grnd_level")
    val grndLevel: Int,

    @field:JsonProperty("humidity")
    val humidity: Int,

    @field:JsonProperty("pressure")
    val pressure: Int,

    @field:JsonProperty("sea_level")
    val seaLevel: Int,

    @field:JsonProperty("feels_like")
    val feelsLike: Double,

    @field:JsonProperty("temp_max")
    val tempMax: Double
)

data class Wind(

    @field:JsonProperty("deg")
    val deg: Int,

    @field:JsonProperty("speed")
    val speed: Double,

    @field:JsonProperty("gust")
    val gust: Double
)

data class Sys(

    @field:JsonProperty("country")
    val country: String,

    @field:JsonProperty("sunrise")
    val sunrise: Int,

    @field:JsonProperty("sunset")
    val sunset: Int
)

data class Clouds(

    @field:JsonProperty("all")
    val all: Int
)