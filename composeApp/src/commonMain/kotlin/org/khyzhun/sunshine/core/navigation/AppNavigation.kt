package org.khyzhun.sunshine.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.khyzhun.sunshine.domain.repository.WeatherRepository
import org.khyzhun.sunshine.presentation.weather.settings.SettingsScreen
import org.khyzhun.sunshine.presentation.weather.settings.SettingsViewModel
import org.khyzhun.sunshine.presentation.weather.weather.WeatherScreen
import org.khyzhun.sunshine.presentation.weather.weather.WeatherViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.Weather.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(Routes.Weather.route) {
            val mainViewModel = getViewModel(Unit, viewModelFactory { WeatherViewModel() })
            WeatherScreen(
                viewModel = mainViewModel,
                onNavigateToSettings = {
                    navController.navigate(route = Routes.Settings.route)
                }
            )
        }
        composable(Routes.Settings.route) {
            val settingsViewModel = getViewModel(Unit, viewModelFactory { SettingsViewModel() })
            SettingsScreen(
                viewModel = settingsViewModel,
                onNavigateBack = navController::popBackStack
            )
        }
    }
}