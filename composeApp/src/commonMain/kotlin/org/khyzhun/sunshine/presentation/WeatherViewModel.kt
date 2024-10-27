package org.khyzhun.sunshine.presentation

import org.khyzhun.sunshine.model.WeatherUi
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState())
    val uiState = _uiState.asStateFlow()

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
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
                it.copy(title = weatherForecast.title)
            }
        }
    }

    private suspend fun getWeatherForecast(): WeatherUi {
//        val weather = httpClient
//            .get("https://api.sunshineapp.com/weather")
//            .body<WeatherUi>()
        return WeatherUi(
            title = "Sunny",
            description = "Clear skies",
            icon = "sun",
            degrees = "25°C",
            wind = "5 km/h",
            humidity = "50%"
        )
    }
}