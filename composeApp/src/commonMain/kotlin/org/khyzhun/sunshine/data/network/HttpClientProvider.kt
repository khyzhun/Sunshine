package org.khyzhun.sunshine.data.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientProvider {
    val client: HttpClient by lazy {
        HttpClient {
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
    }
}