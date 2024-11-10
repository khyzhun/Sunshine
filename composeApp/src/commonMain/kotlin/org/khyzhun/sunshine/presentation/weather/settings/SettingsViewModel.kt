package org.khyzhun.sunshine.presentation.weather.settings

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
        }
    }

    private fun loadSettings() {
        updateState { state ->
            state.value = SettingsUiState(something = true)
        }
    }
}