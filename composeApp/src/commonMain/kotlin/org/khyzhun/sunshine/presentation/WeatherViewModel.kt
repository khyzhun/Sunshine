package org.khyzhun.sunshine.presentation

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.khyzhun.sunshine.data.model.CurrentWeatherResponse
import org.khyzhun.sunshine.data.model.ForecastWeatherResponse
import org.khyzhun.sunshine.model.Forecast
import org.khyzhun.sunshine.model.WeatherState

class WeatherViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState())
    val uiState = _uiState.asStateFlow()

//    private val httpClient = HttpClient {
//        install(ContentNegotiation) {
//            json()
//        }
//    }

    init {
        loadWeatherForecast()
    }

    override fun onCleared() {
//        httpClient.close()
    }

    private fun loadWeatherForecast() {
        viewModelScope.launch {
            val weatherForecast = getWeatherForecast()
            _uiState.update {
                it.copy(
                    city = "San Francisco",
                    icon = "https://raw.githubusercontent.com/khyzhun/Sunshine-KMP/refs/heads/master/images/ic_partly_cloudy.png?raw=true",
                    description = "Clear skies",
                    temperature = 22,
                    forecast = listOf(
                        Forecast("Today", 22, 14, "https://github.com/khyzhun/Sunshine-KMP/blob/master/images/ic_partly_cloudy.png"),
                        Forecast("Monday", 20, 12, "https://github.com/khyzhun/Sunshine-KMP/blob/master/images/ic_rain_thunder.png?raw=true"),
                        Forecast("Thursday", 19, 10, "https://www.gravatar.com/avatar/a819d4fb4286c9a1bdbbc857db5fced4?s=256&d=identicon&r=PG"),
                    ),
                )
            }
        }
    }

    private suspend fun getWeatherForecast(): CurrentWeatherResponse {
//        val weather = httpClient
//            .get("https://api.sunshineapp.com/weather")
//            .body<CurrentWeatherResponse>()
        return CurrentWeatherResponse(
            city = "San Francisco",
            icon = "https://raw.githubusercontent.com/khyzhun/Sunshine-KMP/refs/heads/master/images/ic_partly_cloudy.png?raw=true",
            description = "Clear skies",
            temperature = 22,
            forecast = listOf(
                ForecastWeatherResponse("Today", 22, 14, "https://github.com/khyzhun/Sunshine-KMP/blob/master/images/ic_partly_cloudy.png"),
                ForecastWeatherResponse("Monday", 20, 12, "https://github.com/khyzhun/Sunshine-KMP/blob/master/images/ic_rain_thunder.png?raw=true"),
                ForecastWeatherResponse("Thursday", 19, 10, "https://www.gravatar.com/avatar/a819d4fb4286c9a1bdbbc857db5fced4?s=256&d=identicon&r=PG"),
            ),
        )
    }
}