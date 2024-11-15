package org.khyzhun.sunshine.di

import org.khyzhun.sunshine.data.network.HttpClientProvider
import org.koin.dsl.module

val apiModule = module {
    single { HttpClientProvider }

}