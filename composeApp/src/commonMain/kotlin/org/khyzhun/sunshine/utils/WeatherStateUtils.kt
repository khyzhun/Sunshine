package org.khyzhun.sunshine.utils

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.khyzhun.sunshine.model.WeatherState
import sunshine.composeapp.generated.resources.Res
import sunshine.composeapp.generated.resources.ic_partly_cloudy
import sunshine.composeapp.generated.resources.ic_rain_thunder
import sunshine.composeapp.generated.resources.ic_rainy
import sunshine.composeapp.generated.resources.ic_snowy
import sunshine.composeapp.generated.resources.ic_sunny
import sunshine.composeapp.generated.resources.partly_cloudy
import sunshine.composeapp.generated.resources.rain_thunder
import sunshine.composeapp.generated.resources.rainy
import sunshine.composeapp.generated.resources.snowy
import sunshine.composeapp.generated.resources.sunny


fun getWeatherIcon(state: WeatherState): DrawableResource {
    return when (state) {
        WeatherState.PartlyCloudy -> Res.drawable.ic_partly_cloudy
        WeatherState.RainThunder -> Res.drawable.ic_rain_thunder
        WeatherState.Rainy -> Res.drawable.ic_rainy
        WeatherState.Snowy -> Res.drawable.ic_snowy
        WeatherState.Sunny -> Res.drawable.ic_sunny
        else -> Res.drawable.ic_sunny
    }
}

fun getWeatherTitle(state: WeatherState): StringResource {
    return when (state) {
        WeatherState.PartlyCloudy -> Res.string.partly_cloudy
        WeatherState.RainThunder -> Res.string.rain_thunder
        WeatherState.Rainy -> Res.string.rainy
        WeatherState.Snowy -> Res.string.snowy
        WeatherState.Sunny -> Res.string.sunny
        else -> Res.string.sunny
    }
}