package com.cw.clothesweather.repositories

import com.cw.clothesweather.entity.Recommendation
import org.springframework.data.jpa.repository.JpaRepository

interface RecommendationRepository : JpaRepository<Recommendation, Int> {

    fun findRecommendationByWeatherRangeStartInBeforeAndWeatherRangeEndInAfter(
        wRangeStart: Double,
        wRangeEnd: Double
    ): Recommendation?

}