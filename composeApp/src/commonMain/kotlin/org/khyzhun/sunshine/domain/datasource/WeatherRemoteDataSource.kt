package org.khyzhun.sunshine.domain.datasource

import org.khyzhun.sunshine.domain.model.CurrentWeatherDomain

interface WeatherRemoteDataSource {

    suspend fun getCurrentWeather(): CurrentWeatherDomain

}