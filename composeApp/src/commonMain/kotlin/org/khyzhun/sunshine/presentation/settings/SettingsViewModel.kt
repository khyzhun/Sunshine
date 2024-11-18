package org.khyzhun.sunshine.presentation.settings

import org.khyzhun.sunshine.core.base.BaseViewModel
import org.khyzhun.sunshine.core.base.common.events.Callback
import org.khyzhun.sunshine.core.base.common.events.Dialog
import org.khyzhun.sunshine.core.base.common.events.Progress
import org.khyzhun.sunshine.core.base.common.events.UiEvent

class SettingsViewModel : BaseViewModel<SettingsUiState, Progress, Dialog, Callback>() {

    override fun handleUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is SettingsUiEvent.LoadScreenData -> {
                loadSettings()
            }
            is SettingsUiEvent.UpdateLocation -> {
                updateLocation(uiEvent.location)
            }
            is SettingsUiEvent.UpdateTheme -> {
                updateTheme(uiEvent.isDarkTheme)
            }
            is SettingsUiEvent.UpdateTemperatureUnit -> {
                updateTemperatureUnit(uiEvent.isCelsius)
            }
        }
    }

    private fun loadSettings() {
        updateState { state ->
            state.value = SettingsUiState()
        }
    }

    private fun updateTheme(darkTheme: Boolean) {
        updateState { state ->
            state.value = state.value?.copy(isDarkTheme = darkTheme)
        }
    }

    private fun updateLocation(location: String) {
        updateState { state ->
            state.value = state.value?.copy(location = location)
        }
    }

    private fun updateTemperatureUnit(celsius: Boolean) {
        updateState { state ->
            state.value = state.value?.copy(isCelsius = celsius)
        }
    }
}