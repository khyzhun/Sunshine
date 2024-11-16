package org.khyzhun.sunshine.di

import org.khyzhun.sunshine.presentation.settings.SettingsViewModel
import org.khyzhun.sunshine.presentation.weather.WeatherViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

val viewModelModule = module {
    viewModel { WeatherViewModel(get()) }
    viewModel { SettingsViewModel() }
}