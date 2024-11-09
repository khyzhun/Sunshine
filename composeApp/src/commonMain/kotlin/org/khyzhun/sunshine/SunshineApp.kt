package org.khyzhun.sunshine

import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.khyzhun.sunshine.presentation.weather.WeatherScreen
import org.khyzhun.sunshine.presentation.weather.WeatherViewModel
import org.khyzhun.sunshine.core.theme.AppTheme

@Composable
@Preview
fun SunshineAppView() {
    AppTheme {
        val mainViewModel = getViewModel(Unit, viewModelFactory { WeatherViewModel() })
        WeatherScreen(mainViewModel)
    }
}

expect fun getPlatformName(): String

expect fun setupLogger()