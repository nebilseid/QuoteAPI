package com.example.quoteapi.di

import com.example.quoteapi.Network.QuoteService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent{
    fun quoteService(): QuoteService
}