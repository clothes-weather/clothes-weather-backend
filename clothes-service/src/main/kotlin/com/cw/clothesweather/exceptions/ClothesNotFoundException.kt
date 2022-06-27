package com.cw.clothesweather.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ClothesNotFoundException(id: Int): RuntimeException("Одежда с id = $id не найдена") {
}