package org.khyzhun.sunshine.data.mapper

import org.khyzhun.sunshine.data.model.ForecastWeatherResponse
import org.khyzhun.sunshine.domain.model.ForecastWeatherDomain


fun ForecastWeatherResponse?.toDomain(): ForecastWeatherDomain {
    return ForecastWeatherDomain(
        icon = this?.icon.orEmpty(),
        day = this?.day.orEmpty(),
        temperatureMax = this?.temperatureMax ?: 0,
        temperatureMin = this?.temperatureMin ?: 0
    )
}