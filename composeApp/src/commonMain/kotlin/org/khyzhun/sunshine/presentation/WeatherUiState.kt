package org.khyzhun.sunshine.presentation

import org.khyzhun.sunshine.model.Forecast
import org.khyzhun.sunshine.model.WeatherState

data class WeatherUiState(
    val city: String = "",
    val icon: WeatherState = WeatherState.None,
    val description: String = "",
    val temperature: Int = 0,
    val forecast: List<Forecast> = emptyList(),
)