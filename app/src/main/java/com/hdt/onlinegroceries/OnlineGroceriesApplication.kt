package com.hdt.onlinegroceries

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.hdt.onlinegroceries.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class OnlineGroceriesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context =  this
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@OnlineGroceriesApplication)
            modules(
                listOf(
                    sharedPreferencesModule,
                    roomDatabaseModule,
                    networkModule,
                    viewModelModule,
                    repositoryModule
                )
            )
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}