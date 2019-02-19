package com.example.quoteapi.UI.Home.di.symbol

import com.example.quoteapi.Network.QuoteService
import com.example.quoteapi.UI.Home.di.HomeScope
import com.example.quoteapi.UI.Home.symbolQuote.SymbolHomeContract
import com.example.quoteapi.UI.Home.symbolQuote.SymbolHomePresenter
import dagger.Module
import dagger.Provides


@Module
class QuoteHomeModule (private val view: SymbolHomeContract.View){


    @QuoteScope
    @Provides
    fun provideSymbolQuotePresenter (quoteService : QuoteService):
            SymbolHomeContract.Presenter{
        return SymbolHomePresenter(quoteService,view)
    }

}