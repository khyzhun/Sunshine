package org.khyzhun.sunshine.core.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.khyzhun.sunshine.core.base.common.events.Callback
import org.khyzhun.sunshine.core.base.common.events.Dialog
import org.khyzhun.sunshine.core.base.common.events.EventState
import org.khyzhun.sunshine.core.base.common.events.Progress
import org.khyzhun.sunshine.core.base.common.events.UiEvent
import org.khyzhun.sunshine.core.base.common.state.UiState
import org.khyzhun.sunshine.core.base.common.uidata.ProgressData
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<S : UiState, P : Progress, D : Dialog, C : Callback> : ViewModel() {

    private var _uiState = mutableStateOf<S?>(null)
    val uiState: State<S?> = _uiState

    private var _eventState = mutableStateOf(EventState<P, D>())
    val eventState: State<EventState<P, D>> = _eventState

    protected fun updateState(block: (state: MutableState<S?>) -> Unit) {
        block.invoke(_uiState)
    }

    abstract fun handleUiEvent(uiEvent: UiEvent)

    protected fun launch(
        block: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(context = EmptyCoroutineContext /*+ handler*/, block = block)

    protected fun launchWithProgress(
        progress: P? = null,
        block: suspend CoroutineScope.() -> Unit
    ) = launch {
        try {
            _eventState.value = _eventState.value.copy(progress = ProgressData(progress))
            block()
        } finally {
            _eventState.value = _eventState.value.copy(progress = null)
        }
    }


}