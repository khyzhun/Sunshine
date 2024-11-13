package org.khyzhun.sunshine.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CurrentWeatherResponse(
    @SerialName("city")
    val city: String? = null,
    @SerialName("icon")
    val icon: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("temperature")
    val temperature: Int? = null,
    @SerialName("background_color")
    val backgroundColor: String? = null,
    @SerialName("forecast")
    val forecast: List<ForecastWeatherResponse?>? = null,
)