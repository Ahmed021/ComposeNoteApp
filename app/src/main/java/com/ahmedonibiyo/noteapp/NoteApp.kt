package com.ahmedonibiyo.noteapp

import android.app.Application
import com.ahmedonibiyo.noteapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NoteApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NoteApp)
            androidLogger()

            modules(appModule)
        }
    }
}