package com.hdt.onlinegroceries.di

import android.content.Context
import com.hdt.onlinegroceries.domain.prefs.AppSettings
import com.hdt.onlinegroceries.utils.SharePreference
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val PREF_NAME = "PREF_NAME"
val sharedPreferencesModule = module {
    single { androidContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE) }
    single { androidContext().contentResolver }
    single { SharePreference(get(), get()) }
    single { AppSettings(androidContext()) }
}