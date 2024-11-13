package org.khyzhun.sunshine.domain.model

data class CurrentWeatherDomain(
    val city: String,
    val icon: String,
    val description: String,
    val temperature: Int,
    val backgroundColor: String,
    val forecast: List<ForecastWeatherDomain>,
)