package org.khyzhun.sunshine

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

actual fun setupLogger() {
    Napier.base(DebugAntilog())
}