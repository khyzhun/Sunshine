package org.khyzhun.sunshine.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherUi(
    val title: String,
    val description: String,
    val icon: String,
    val degrees: String,
    val wind: String,
    val humidity: String,
)