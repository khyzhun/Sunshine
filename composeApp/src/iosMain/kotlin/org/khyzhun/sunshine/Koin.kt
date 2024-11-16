package org.khyzhun.sunshine

import org.khyzhun.sunshine.di.apiModule
import org.khyzhun.sunshine.di.dataSourceModule
import org.khyzhun.sunshine.di.repositoryModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun doInitKoin() {
    startKoin {
        modules(appModule())
    }
}

actual fun appModule(): List<Module> {
    return listOf(
        apiModule,
        dataSourceModule,
        repositoryModule,
    )
}