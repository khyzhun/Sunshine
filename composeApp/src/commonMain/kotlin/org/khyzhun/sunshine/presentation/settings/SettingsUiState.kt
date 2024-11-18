package org.khyzhun.sunshine.presentation.settings

import org.khyzhun.sunshine.core.base.common.state.UiState

data class SettingsUiState(
    val location: String = "",
    val isDarkTheme: Boolean = false,
    val isCelsius: Boolean = true
) : UiState