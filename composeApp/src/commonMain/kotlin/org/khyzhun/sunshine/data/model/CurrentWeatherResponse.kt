package org.khyzhun.sunshine.data.model

class CurrentWeatherResponse(
    val city: String? = null,
    val icon: String? = null,
    val description: String? = null,
    val temperature: Int? = null,
    val forecast: List<ForecastWeatherResponse?>? = null,
)