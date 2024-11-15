package org.khyzhun.sunshine.di

import org.khyzhun.sunshine.data.datasource.WeatherRemoteDataSourceImpl
import org.khyzhun.sunshine.domain.datasource.WeatherRemoteDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {
    single { WeatherRemoteDataSourceImpl(get()) } bind WeatherRemoteDataSource::class
}