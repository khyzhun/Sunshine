package org.khyzhun.sunshine.model

data class Forecast(
    val day: String,
    val temperatureMax: Int,
    val temperatureMin: Int,
    val icon: WeatherState,
)