package org.khyzhun.sunshine.data.mapper

import org.khyzhun.sunshine.data.model.response.CurrentWeatherResponse
import org.khyzhun.sunshine.domain.model.CurrentWeatherDomain

fun CurrentWeatherResponse.toDomain(): CurrentWeatherDomain {
    return CurrentWeatherDomain(
        city = this.city.toString(),
        icon = this.icon.toString(),
        description = this.description.toString(),
        temperature = this.temperature ?: 0,
        backgroundColor = this.backgroundColor.orEmpty(),
        forecast = this.forecast?.map { it.toDomain() } ?: emptyList()
    )
}
