package org.khyzhun.sunshine.presentation.settings

import org.khyzhun.sunshine.core.base.common.events.UiEvent

sealed class SettingsUiEvent : UiEvent {

    data object LoadScreenData : SettingsUiEvent()

}