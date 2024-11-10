package org.khyzhun.sunshine.presentation.weather.weather

import org.khyzhun.sunshine.core.base.common.state.UiState
import org.khyzhun.sunshine.domain.model.ForecastWeatherDomain

data class WeatherUiState(
    val city: String = "",
    val icon: String = "",
    val description: String = "",
    val temperature: Int = 0,
    val forecast: List<ForecastWeatherDomain> = emptyList(),
) : UiState