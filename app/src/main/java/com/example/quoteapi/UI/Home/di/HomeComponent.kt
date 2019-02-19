package com.example.quoteapi.UI.Home.di

import com.example.quoteapi.UI.Home.MainActivity
import com.example.quoteapi.di.AppComponent
import dagger.Component

@Component(dependencies = [AppComponent::class],modules =[HomeModules::class])
@HomeScope

interface HomeComponent {
    fun inject (mainActivity: MainActivity)
    }
