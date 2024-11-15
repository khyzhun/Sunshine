package org.khyzhun.sunshine.presentation.weather

import org.khyzhun.sunshine.core.base.BaseViewModel
import org.khyzhun.sunshine.core.base.common.events.Callback
import org.khyzhun.sunshine.core.base.common.events.Dialog
import org.khyzhun.sunshine.core.base.common.events.Progress
import org.khyzhun.sunshine.core.base.common.events.UiEvent
import org.khyzhun.sunshine.data.repository.WeatherRepositoryImpl
import org.khyzhun.sunshine.domain.repository.WeatherRepository

class WeatherViewModel(
    private val weatherRepository: WeatherRepository
) : BaseViewModel<WeatherUiState, Progress, Dialog, Callback>() {

    override fun handleUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is WeatherUiEvent.LoadScreenData -> {
                loadWeatherForecast()
            }
        }
    }

    private fun loadWeatherForecast() {
        launch {
            val weatherForecast = weatherRepository.getCurrentWeather()
            updateState { currentState ->
                currentState.value = WeatherUiState(
                    city = weatherForecast.city,
                    icon = weatherForecast.icon,
                    description = weatherForecast.description,
                    temperature = weatherForecast.temperature,
                    backgroundColor = weatherForecast.backgroundColor,
                    forecast = weatherForecast.forecast
                )
            }
        }
    }
}