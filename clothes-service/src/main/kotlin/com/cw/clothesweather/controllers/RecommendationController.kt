package com.cw.clothesweather.controllers

import com.cw.clothesweather.entity.Recommendation
import com.cw.clothesweather.services.RecommendationService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/api/v1/recommendations")
@Tag(name = "API РЕКОМЕНДАЦИЙ V1")
class RecommendationController(private val recommendationService: RecommendationService) {

    @GetMapping("/list")
    @RolesAllowed("user")
    fun getAll() = recommendationService.getAllRecommendation()

    @GetMapping
    @RolesAllowed("user")
    fun getRecommendation(@RequestParam weatherRangeStart: Double, @RequestParam weatherRangeEnd: Double): String? {
        return recommendationService.getRecommendation(weatherRangeStart, weatherRangeEnd)
    }

    @PostMapping
    @RolesAllowed("admin")
    fun addRecommendation(@RequestBody request: Recommendation): Recommendation {
        return recommendationService.addRecommendation(request)
    }

    @PutMapping("/{id}")
    @RolesAllowed("admin")
    fun updateRecommendation(@PathVariable id: Int, @RequestBody request: Recommendation): Recommendation {
        return recommendationService.updateRecommendation(id, request)
    }

    @DeleteMapping
    @RolesAllowed("admin")
    fun deleteRecommendation(@RequestParam recommendationId: Int): String {
        recommendationService.deleteRecommendation(recommendationId)
        return "Рекомендация удалена"
    }
}