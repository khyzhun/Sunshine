package org.khyzhun.sunshine.core.navigation

internal sealed class Routes(val route: String) {
    data object Weather : Routes("weather")
    data object Settings : Routes("settings")
}