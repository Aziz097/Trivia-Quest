package com.example.triviaquest

import android.app.Application
import com.example.triviaquest.di.appModule
import com.example.triviaquest.di.networkModule
import com.example.triviaquest.di.repositoryModule
import com.example.triviaquest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    appModule,
                    networkModule,
                    viewModelModule,
                    repositoryModule
                )
            )
        }
    }
}