package com.example.quoteapi

import android.app.Application
import com.example.quoteapi.di.AppComponent
import com.example.quoteapi.di.DaggerAppComponent


class App: Application(){
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()

    }
    fun getComponent()=appComponent
}