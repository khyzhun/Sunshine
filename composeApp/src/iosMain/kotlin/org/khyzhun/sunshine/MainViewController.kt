package org.khyzhun.sunshine

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { SunshineAppView() }

actual fun getPlatformName(): String = "iOS"