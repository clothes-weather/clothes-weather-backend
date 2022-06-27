package com.cw.clothesweather.entity

import javax.persistence.*

@Entity
@Table(name = "recommendations")
data class Recommendation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val recommendation: String,
    @Column(name = "weather_range_start")
    val weatherRangeStart: Double,
    @Column(name = "weather_range_end")
    val weatherRangeEnd: Double
)