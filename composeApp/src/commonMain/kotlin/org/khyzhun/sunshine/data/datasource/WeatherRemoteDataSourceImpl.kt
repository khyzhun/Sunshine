package org.khyzhun.sunshine.data.datasource

import io.ktor.client.call.body
import io.ktor.client.request.get
import org.khyzhun.sunshine.data.mapper.toDomain
import org.khyzhun.sunshine.data.model.CurrentWeatherResponse
import org.khyzhun.sunshine.data.network.HttpClientProvider
import org.khyzhun.sunshine.domain.datasource.WeatherRemoteDataSource
import org.khyzhun.sunshine.domain.model.CurrentWeatherDomain

class WeatherRemoteDataSourceImpl(
    private val httpClient: HttpClientProvider
) : WeatherRemoteDataSource {

    private val requestUrl = "https://raw.githubusercontent.com/khyzhun/Sunshine-KMP/refs/heads/master/json/current_weather_response.json"

    override suspend fun getCurrentWeather(): CurrentWeatherDomain {
        val response = httpClient
            .client
            .get(requestUrl)

        val result = response.body<CurrentWeatherResponse>()
        return result.toDomain()
    }
}