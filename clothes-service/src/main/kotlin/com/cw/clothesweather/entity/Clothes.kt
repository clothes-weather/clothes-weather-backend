package com.cw.clothesweather.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Clothes(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val headwear: String,
    val outherwear: String,
    val pants: String,
    val shoes: String
)
