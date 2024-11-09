package org.khyzhun.sunshine.domain.model

data class ForecastWeatherDomain(
    val day: String,
    val temperatureMax: Int,
    val temperatureMin: Int,
    val icon: String,
)