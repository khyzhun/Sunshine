package org.khyzhun.sunshine.di

import org.khyzhun.sunshine.data.network.provideHttpClient
import org.koin.dsl.module

val apiModule = module {
    single { provideHttpClient() }

}