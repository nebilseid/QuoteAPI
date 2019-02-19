package com.example.quoteapi.UI.Home

import com.example.quoteapi.Model.Response

interface QuoteListContract {
    interface View {
        fun showResults(results: List<Response>)
        fun showError(message: String)
    }

    interface Presenter {
        fun getQuoteList()
    }
}