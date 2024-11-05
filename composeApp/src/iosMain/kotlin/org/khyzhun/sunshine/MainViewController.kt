package org.khyzhun.sunshine

import androidx.compose.ui.window.ComposeUIViewController
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

fun MainViewController() = ComposeUIViewController { SunshineAppView() }

actual fun getPlatformName(): String = "iOS"

actual fun setupLogger() {
    Napier.base(DebugAntilog())
}