package com.cw.clothesweather.mappers

interface ModelMapper<D, M> {

    fun fromModel(entity: M): D

    fun toModel(domain: D): M

}