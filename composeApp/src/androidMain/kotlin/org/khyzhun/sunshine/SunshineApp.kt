package org.khyzhun.sunshine

import android.app.Application

class SunshineApp : Application() {

    override fun onCreate() {
        super.onCreate()
        doInitKoin()
        setupLogger()
    }

}