package com.saba.domain

import android.app.Application
import com.saba.domain.Modules.articleModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(articleModule))
    }

}