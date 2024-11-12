package org.khyzhun.sunshine.data.repository

import org.khyzhun.sunshine.data.datasource.WeatherRemoteDataSourceImpl
import org.khyzhun.sunshine.data.network.HttpClientProvider
import org.khyzhun.sunshine.domain.datasource.WeatherRemoteDataSource
import org.khyzhun.sunshine.domain.model.CurrentWeatherDomain
import org.khyzhun.sunshine.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherRemoteDataSource: WeatherRemoteDataSource = WeatherRemoteDataSourceImpl(HttpClientProvider)
) : WeatherRepository {

    override suspend fun getCurrentWeather(): CurrentWeatherDomain {
        return weatherRemoteDataSource.getCurrentWeather()
    }

}