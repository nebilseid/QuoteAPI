package com.example.quoteapi.UI.Home.di.symbol


import com.example.quoteapi.UI.Home.symbolQuote.SymbolQuoteActivity
import com.example.quoteapi.di.AppComponent
import dagger.Component


@Component(dependencies = [AppComponent::class],modules =[QuoteHomeModule::class])
@QuoteScope
interface QuoteComponent {
    fun inject (symbolQuoteActivity: SymbolQuoteActivity)
}