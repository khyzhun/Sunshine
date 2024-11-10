package org.khyzhun.sunshine.core.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.khyzhun.sunshine.core.base.common.events.Callback
import org.khyzhun.sunshine.core.base.common.events.Dialog
import org.khyzhun.sunshine.core.base.common.events.Progress
import org.khyzhun.sunshine.core.base.common.state.UiState

@Composable
fun <S : UiState, P : Progress, D : Dialog, C : Callback> BaseContentLayout(
    viewModel: BaseViewModel<S, P, D, C>,
    onBackPressed: (() -> Unit)? = null,
    content: @Composable (uiState: S?) -> Unit
) {

//    BackHandler(
//        enabled = onBackPressed != null,
//        onBack = {
//            onBackPressed?.invoke()
//        }
//    )
    
    val uiState by viewModel.uiState
    val eventState by viewModel.eventState

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        content(uiState)
    }
}