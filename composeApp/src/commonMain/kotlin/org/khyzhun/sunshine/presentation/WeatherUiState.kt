package org.khyzhun.sunshine.presentation

import org.khyzhun.sunshine.model.Forecast

data class WeatherUiState(
    val city: String = "",
    val icon: String = "",
    val description: String = "",
    val temperature: Int = 0,
    val forecast: List<Forecast> = emptyList(),
)