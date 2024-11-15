package org.khyzhun.sunshine.di

import org.khyzhun.sunshine.data.repository.WeatherRepositoryImpl
import org.khyzhun.sunshine.domain.repository.WeatherRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherRepositoryImpl(get()) } bind WeatherRepository::class
}