package org.khyzhun.sunshine.core.base.common.events

import org.khyzhun.sunshine.core.base.common.uidata.ProgressData

data class EventState<P : Progress, D : Dialog>(
    val progress: ProgressData<P>? = null,
    val dialog: D? = null
)

interface Progress
interface Dialog
interface Message
interface Callback

interface UiEvent