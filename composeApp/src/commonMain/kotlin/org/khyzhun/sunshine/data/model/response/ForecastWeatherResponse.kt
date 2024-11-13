package org.khyzhun.sunshine.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastWeatherResponse(
    @SerialName("day")
    val day: String? = null,
    @SerialName("temperature_max")
    val temperatureMax: Int? = null,
    @SerialName("temperature_min")
    val temperatureMin: Int? = null,
    @SerialName("icon")
    val icon: String? = null,
)