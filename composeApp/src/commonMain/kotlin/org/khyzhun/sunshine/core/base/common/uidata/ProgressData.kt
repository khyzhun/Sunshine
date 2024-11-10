package org.khyzhun.sunshine.core.base.common.uidata

import org.khyzhun.sunshine.core.base.common.events.Progress

data class ProgressData<P : Progress>(
    val progress: P? = null
)