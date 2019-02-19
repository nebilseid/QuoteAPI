package com.example.quoteapi.UI.Home.symbolQuote

import com.example.quoteapi.Model.Response
import com.example.quoteapi.Network.QuoteService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class SymbolHomePresenter(
    private val quoteService: QuoteService,
    private val view: SymbolHomeContract.View
) : SymbolHomeContract.Presenter {


    private val compositeDisposable = CompositeDisposable()


    override fun getSymbolQuote(symbol:String) {
        compositeDisposable.add(
            quoteService.getSymbolQuote(symbol)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view.showResults(it) },
                    { failure -> view.showError(failure?.message ?: "An unknown error happened") })
        )
    }
}


