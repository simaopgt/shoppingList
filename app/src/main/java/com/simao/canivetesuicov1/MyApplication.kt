package com.simao.canivetesuicov1

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.simao.canivetesuicov1.di.modules

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(modules)
        }

    }
}