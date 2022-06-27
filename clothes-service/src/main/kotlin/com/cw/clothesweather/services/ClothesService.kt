package com.cw.clothesweather.services

import com.cw.clothesweather.entity.Clothes
import com.cw.clothesweather.exceptions.ClothesNotFoundException
import com.cw.clothesweather.repositories.ClothesRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ClothesService(private val clothesRepository: ClothesRepository) {

    fun getAllClothes(): List<Clothes> = clothesRepository.findAll()

    fun getClothes(id: Int): Clothes =
        clothesRepository.findByIdOrNull(id) ?: throw ClothesNotFoundException(id)

    fun addClothes(clothes: Clothes): Clothes = clothesRepository.save(
        Clothes(
            headwear = clothes.headwear,
            outherwear = clothes.outherwear,
            pants = clothes.pants,
            shoes = clothes.shoes
        )
    )

    fun updateClothes(id: Int, clothes: Clothes): Clothes {
        val oldClothes = clothesRepository.findByIdOrNull(id) ?: throw ClothesNotFoundException(id)

        return clothesRepository.save(
            oldClothes.copy(
                headwear = clothes.headwear,
                outherwear = clothes.outherwear,
                pants = clothes.pants,
                shoes = clothes.shoes
            )
        )
    }

    fun deleteClothes(id: Int) = clothesRepository.deleteById(id)
}