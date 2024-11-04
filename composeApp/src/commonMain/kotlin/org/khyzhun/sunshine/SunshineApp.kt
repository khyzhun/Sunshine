package org.khyzhun.sunshine

import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.khyzhun.sunshine.presentation.WeatherScreen
import org.khyzhun.sunshine.presentation.WeatherViewModel
import org.khyzhun.sunshine.theme.AppTheme

@Composable
@Preview
fun SunshineApp() {
    AppTheme {
        val mainViewModel = getViewModel(Unit, viewModelFactory { WeatherViewModel() })
        WeatherScreen(mainViewModel)
    }
}

expect fun getPlatformName(): String