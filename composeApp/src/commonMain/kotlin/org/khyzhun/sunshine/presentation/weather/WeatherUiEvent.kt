package org.khyzhun.sunshine.presentation.weather

import org.khyzhun.sunshine.core.base.common.events.UiEvent

sealed class WeatherUiEvent : UiEvent {

    data object LoadScreenData : WeatherUiEvent()

}