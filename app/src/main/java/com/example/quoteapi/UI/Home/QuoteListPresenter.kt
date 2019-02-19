package com.example.quoteapi.UI.Home

import com.example.quoteapi.Network.QuoteService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class QuoteListPresenter(
    private val quoteService: QuoteService,
    private val view: QuoteListContract.View
) : QuoteListContract.Presenter {
    private val compositeDisposable = CompositeDisposable()


    override fun getQuoteList() {
        compositeDisposable.add(
            quoteService.getStocksQuote()
                .subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view.showResults(it) },
                    { failure -> view.showError(failure?.message ?: "An unknown error happened") })
        )
    }
}


