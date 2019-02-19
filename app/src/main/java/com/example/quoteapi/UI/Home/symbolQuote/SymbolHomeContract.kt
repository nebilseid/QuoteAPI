package com.example.quoteapi.UI.Home.symbolQuote

import com.example.quoteapi.Model.Response


interface SymbolHomeContract {
    interface View {
        fun showResults(results:Response)
        fun showError(message: String)
    }

    interface Presenter {
        fun getSymbolQuote(symbol:String)
    }
}