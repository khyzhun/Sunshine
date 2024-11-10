package org.khyzhun.sunshine.presentation.weather.weather

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.khyzhun.sunshine.core.base.BaseViewModel
import org.khyzhun.sunshine.core.base.common.events.Callback
import org.khyzhun.sunshine.core.base.common.events.Dialog
import org.khyzhun.sunshine.core.base.common.events.Progress
import org.khyzhun.sunshine.core.base.common.events.UiEvent
import org.khyzhun.sunshine.data.model.CurrentWeatherResponse
import org.khyzhun.sunshine.domain.model.ForecastWeatherDomain

class WeatherViewModel : BaseViewModel<WeatherUiState, Progress, Dialog, Callback>() {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
            register(
                ContentType.Text.Plain, KotlinxSerializationConverter(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            )
        }
    }

    override fun handleUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is WeatherUiEvent.LoadScreenData -> {
                loadWeatherForecast()
            }
        }
    }

    override fun onCleared() {
        httpClient.close()
    }

    private fun loadWeatherForecast() {
        launch {
            val weatherForecast = getWeatherForecast()
            updateState { currentState ->
                val forecast = weatherForecast.forecast?.map { forecast ->
                    ForecastWeatherDomain(
                        icon = forecast?.icon.toString(),
                        day = forecast?.day.toString(),
                        temperatureMax = forecast?.temperatureMax ?: 0,
                        temperatureMin = forecast?.temperatureMin ?: 0
                    )
                }.orEmpty()

                currentState.value = WeatherUiState(
                    city = weatherForecast.city.toString(),
                    icon = weatherForecast.icon.toString(),
                    description = weatherForecast.description.toString(),
                    temperature = weatherForecast.temperature ?: 0,
                    forecast = forecast
                )
            }
        }
    }

    private suspend fun getWeatherForecast(): CurrentWeatherResponse {
        val response =
            httpClient.get("https://raw.githubusercontent.com/khyzhun/Sunshine-KMP/refs/heads/master/json/current_weather_response.json")
        val result = response.body<CurrentWeatherResponse>()
        return result
    }
}