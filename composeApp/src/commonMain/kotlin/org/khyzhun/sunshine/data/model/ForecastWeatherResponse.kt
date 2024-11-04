package org.khyzhun.sunshine.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ForecastWeatherResponse(
    val day: String? = null,
    val temperatureMax: Int? = null,
    val temperatureMin: Int? = null,
    val icon: String? = null,
)