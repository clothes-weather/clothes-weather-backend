package com.cw.clothesweather.repositories

import com.cw.clothesweather.entity.Clothes
import org.springframework.data.jpa.repository.JpaRepository

interface ClothesRepository : JpaRepository<Clothes, Int>