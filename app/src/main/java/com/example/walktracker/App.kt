package com.example.walktracker

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // Adding Timber support for Logging purpose
        Timber.plant(Timber.DebugTree())
    }
}