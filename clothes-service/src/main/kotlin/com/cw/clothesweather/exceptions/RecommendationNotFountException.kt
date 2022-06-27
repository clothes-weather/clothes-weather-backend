package com.cw.clothesweather.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class RecommendationNotFountException : RuntimeException("Рекомендация не найдена")