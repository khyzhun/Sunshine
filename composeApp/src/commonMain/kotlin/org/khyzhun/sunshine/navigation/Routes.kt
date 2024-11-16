package org.khyzhun.sunshine.navigation

internal sealed class Routes(val route: String) {
    data object Weather : Routes("weather")
    data object Settings : Routes("settings")
}