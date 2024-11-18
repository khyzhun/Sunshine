package org.khyzhun.sunshine.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.khyzhun.sunshine.data.api.WeatherApi
import org.khyzhun.sunshine.data.mapper.toDomain
import org.khyzhun.sunshine.data.model.response.CurrentWeatherResponse
import org.khyzhun.sunshine.domain.datasource.WeatherRemoteDataSource
import org.khyzhun.sunshine.domain.model.CurrentWeatherDomain

class WeatherRemoteDataSourceImpl(
    private val client: HttpClient
) : WeatherRemoteDataSource {

    override suspend fun getCurrentWeather(): CurrentWeatherDomain {
        val response = client.get(WeatherApi.getCurrentWeather())
        val result = response.body<CurrentWeatherResponse>()
        return result.toDomain()
    }
}