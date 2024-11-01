package org.khyzhun.sunshine.model

interface WeatherState {
    data object PartlyCloudy : WeatherState
    data object RainThunder : WeatherState
    data object Rainy : WeatherState
    data object Snowy : WeatherState
    data object Sunny : WeatherState
    data object None : WeatherState
}