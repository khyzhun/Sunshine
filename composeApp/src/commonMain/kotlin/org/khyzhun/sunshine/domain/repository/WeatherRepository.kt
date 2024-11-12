package org.khyzhun.sunshine.domain.repository

import org.khyzhun.sunshine.domain.model.CurrentWeatherDomain

interface WeatherRepository {

    suspend fun getCurrentWeather(): CurrentWeatherDomain

}