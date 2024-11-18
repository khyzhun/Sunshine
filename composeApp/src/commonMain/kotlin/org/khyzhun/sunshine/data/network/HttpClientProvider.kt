package org.khyzhun.sunshine.data.network

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.engine.type
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.khyzhun.sunshine.data.api.errors.ApiException
import org.koin.core.qualifier.qualifier

fun provideHttpClient(): HttpClient {
    return HttpClient {
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
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.d(tag = "HttpClient", message = message)
                }
            }
            level = LogLevel.BODY
        }
        install(DefaultRequest) {
            header("Accept", "application/json")
        }
        HttpResponseValidator {
            validateResponse { response ->
                if (response.status.value >= 400) {
                    throw ApiException(response.status.value, response.toString())
                }
            }
            handleResponseException { exception, httpRequest ->
                Napier.e(tag = "HttpClient", message = exception.message + "/" + httpRequest.toString())
            }
        }
    }
}