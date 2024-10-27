package org.khyzhun.sunshine

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { SunshineApp() }

actual fun getPlatformName(): String = "iOS"