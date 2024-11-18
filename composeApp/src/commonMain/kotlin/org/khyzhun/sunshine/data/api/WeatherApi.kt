package org.khyzhun.sunshine.data.api

object WeatherApi {

    fun getCurrentWeather(): String {
        return "https://raw.githubusercontent.com/khyzhun/Sunshine-KMP/refs/heads/master/json/current_weather_response.json"
    }

}