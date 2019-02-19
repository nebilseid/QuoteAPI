package com.example.quoteapi.UI.Home.di

import com.example.quoteapi.Network.QuoteService
import com.example.quoteapi.UI.Home.QuoteListContract
import com.example.quoteapi.UI.Home.QuoteListPresenter
import com.example.quoteapi.UI.Home.symbolQuote.SymbolHomeContract
import com.example.quoteapi.UI.Home.symbolQuote.SymbolHomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModules(private val view:QuoteListContract.View){

    @HomeScope
    @Provides
    fun provideQuoteListPresenter (quoteService : QuoteService):
            QuoteListContract.Presenter{
        return QuoteListPresenter(quoteService,view)
    }

}