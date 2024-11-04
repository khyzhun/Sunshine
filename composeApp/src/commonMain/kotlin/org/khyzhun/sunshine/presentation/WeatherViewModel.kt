package org.khyzhun.sunshine.presentation

import dev.icerock.moko.mvvm.viewmodel.ViewModel
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
import org.khyzhun.sunshine.data.model.CurrentWeatherResponse
import org.khyzhun.sunshine.model.Forecast

class WeatherViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState())
    val uiState = _uiState.asStateFlow()

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

    init {
        loadWeatherForecast()
    }

    override fun onCleared() {
        httpClient.close()
    }

    private fun loadWeatherForecast() {
        viewModelScope.launch {
            val weatherForecast = getWeatherForecast()

            _uiState.update {
                it.copy(
                    city = weatherForecast.city.toString(),
                    icon = weatherForecast.icon.toString(),
                    description = weatherForecast.description.toString(),
                    temperature = weatherForecast.temperature ?: 0,
                    forecast = weatherForecast.forecast?.map { forecast ->
                        Forecast(
                            icon = forecast?.icon.toString(),
                            day = forecast?.day.toString(),
                            temperatureMax = forecast?.temperatureMax ?: 0,
                            temperatureMin = forecast?.temperatureMin ?: 0
                        )
                    }.orEmpty()
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