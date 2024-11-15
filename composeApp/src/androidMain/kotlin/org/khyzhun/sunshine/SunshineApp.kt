package org.khyzhun.sunshine

import android.app.Application
import org.khyzhun.sunshine.di.apiModule
import org.khyzhun.sunshine.di.dataSourceModule
import org.khyzhun.sunshine.di.repositoryModule
import org.khyzhun.sunshine.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SunshineApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SunshineApp)
            modules(listOf(
                dataSourceModule,
                repositoryModule,
                viewModelModule,
                apiModule
            ))
        }

        setupLogger()
    }

}