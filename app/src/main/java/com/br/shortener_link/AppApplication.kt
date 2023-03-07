package com.br.shortener_link

import android.app.Application
import com.br.shortener_link.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@AppApplication)
            modules(
                AppModule.dataModule,
                AppModule.domainModule,
                AppModule.presentationModule
            )
        }
    }
}