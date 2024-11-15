package org.khyzhun.sunshine

import androidx.compose.ui.window.ComposeUIViewController
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.khyzhun.sunshine.di.apiModule
import org.khyzhun.sunshine.di.dataSourceModule
import org.khyzhun.sunshine.di.repositoryModule
import org.khyzhun.sunshine.di.viewModelModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController { SunshineAppView() }

fun initKoin() {
    startKoin {
        modules(listOf(
            dataSourceModule,
            repositoryModule,
            viewModelModule,
            apiModule
        ))
    }
}

actual fun getPlatformName(): String = "iOS"

actual fun setupLogger() {
    Napier.base(DebugAntilog())
}