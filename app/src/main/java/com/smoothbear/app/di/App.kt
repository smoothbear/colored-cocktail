package com.smoothbear.app.di

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    init {
        instance = this
    }

    companion object {
        lateinit var instance: App

        fun getApplicationContext(): Context {
            return instance.applicationContext
        }
    }
}