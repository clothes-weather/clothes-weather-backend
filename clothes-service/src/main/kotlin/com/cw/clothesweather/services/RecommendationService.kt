package com.cw.clothesweather.services

import com.cw.clothesweather.entity.Recommendation
import com.cw.clothesweather.exceptions.RecommendationNotFountException
import com.cw.clothesweather.repositories.RecommendationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RecommendationService(private val recommendationRepository: RecommendationRepository) {

    fun addRecommendation(recommendation: Recommendation): Recommendation {
        return recommendationRepository.save(
            Recommendation(
                recommendation = recommendation.recommendation,
                weatherRangeStart = recommendation.weatherRangeStart,
                weatherRangeEnd = recommendation.weatherRangeEnd
            )
        )
    }

    fun deleteRecommendation(id: Int) {
        recommendationRepository.deleteById(id)
    }

    fun updateRecommendation(id: Int, recommendation: Recommendation): Recommendation {
        val oldRecommendation = recommendationRepository.findByIdOrNull(id) ?: throw RecommendationNotFountException()
        return recommendationRepository.save(
            oldRecommendation.copy(
                recommendation = recommendation.recommendation,
                weatherRangeStart = recommendation.weatherRangeStart,
                weatherRangeEnd = recommendation.weatherRangeEnd
            )
        )
    }

    fun getAllRecommendation(): List<Recommendation> {
        return recommendationRepository.findAll()
    }

    fun getRecommendation(wRangeStart: Double, wRangeEnd: Double): String {
        val recommendation =
            recommendationRepository.findRecommendationByWeatherRangeStartInBeforeAndWeatherRangeEndInAfter(
                wRangeStart,
                wRangeEnd
            ) ?: throw RecommendationNotFountException()
        return recommendation.recommendation
    }
}