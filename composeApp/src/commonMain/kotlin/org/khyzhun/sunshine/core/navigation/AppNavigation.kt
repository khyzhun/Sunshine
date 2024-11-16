package org.khyzhun.sunshine.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.khyzhun.sunshine.presentation.settings.SettingsScreen
import org.khyzhun.sunshine.presentation.settings.SettingsViewModel
import org.khyzhun.sunshine.presentation.weather.WeatherScreen
import org.khyzhun.sunshine.presentation.weather.WeatherViewModel

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
            val viewModel = getViewModel(Unit, viewModelFactory { WeatherViewModel() })

            WeatherScreen(
                viewModel = viewModel,
                onNavigateToSettings = {
                    navController.navigate(route = Routes.Settings.route)
                }
            )
        }
        composable(Routes.Settings.route) {
            val viewModel = getViewModel(Unit, viewModelFactory { SettingsViewModel() })
            SettingsScreen(
                viewModel = viewModel,
                onNavigateBack = navController::popBackStack
            )
        }
    }
}