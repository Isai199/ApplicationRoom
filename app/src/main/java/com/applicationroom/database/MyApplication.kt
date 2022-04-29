package com.applicationroom.database

import android.app.Application

open class MyApplication : Application() {
    override fun onCreate() {
        DataBaseManager.instance.initializeDb(applicationContext)
        super.onCreate()
    }
}