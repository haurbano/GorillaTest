package com.haurbano.gorilla

import android.app.Application
import com.haurbano.gorilla.di.postModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GorillaApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GorillaApp)
            modules(postModule)
        }
    }
}