package org.khyzhun.sunshine.presentation

data class WeatherUiState(
    val title: String = "",
    val description: String = "",
    val icon: String = "",
    val degrees: String = "",
    val wind: String = "",
    val humidity: String = "",
)