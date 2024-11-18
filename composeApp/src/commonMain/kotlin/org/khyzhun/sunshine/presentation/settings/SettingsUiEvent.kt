package org.khyzhun.sunshine.presentation.settings

import org.khyzhun.sunshine.core.base.common.events.UiEvent

sealed class SettingsUiEvent : UiEvent {

    data object LoadScreenData : SettingsUiEvent()

    data class UpdateLocation(val location: String) : SettingsUiEvent()

    data class UpdateTheme(val isDarkTheme: Boolean) : SettingsUiEvent()

    data class UpdateTemperatureUnit(val isCelsius: Boolean) : SettingsUiEvent()

}