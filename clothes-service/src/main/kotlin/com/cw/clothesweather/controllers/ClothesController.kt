package com.cw.clothesweather.controllers

import com.cw.clothesweather.entity.Clothes
import com.cw.clothesweather.services.ClothesService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/api/v1/clothes")
@Tag(name = "API ОДЕЖДЫ V1")
class ClothesController(private val clothesService: ClothesService) {

    @GetMapping
    @RolesAllowed("user")
    fun getAll(): List<Clothes> {
        return clothesService.getAllClothes()
    }

    @GetMapping("/{id}")
    @RolesAllowed("user")
    fun getClothes(@PathVariable("id") clothesId: Int): Clothes? {
        return clothesService.getClothes(clothesId)
    }

    @PostMapping
    @RolesAllowed("user")
    fun addClothes(@RequestBody request: Clothes): Clothes {
        return clothesService.addClothes(request)
    }

    @PutMapping("/{id}")
    @RolesAllowed("user")
    fun updateClothes(@PathVariable id: Int, @RequestBody request: Clothes): Clothes {
        return clothesService.updateClothes(id, request)
    }

    @DeleteMapping
    @RolesAllowed("user")
    fun deleteClothes(@RequestParam ClothesId: Int): String {
        clothesService.deleteClothes(ClothesId)
        return "Одежда удалена"
    }
}