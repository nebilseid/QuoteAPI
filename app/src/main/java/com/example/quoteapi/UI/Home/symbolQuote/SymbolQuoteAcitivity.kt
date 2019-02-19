package com.example.quoteapi.UI.Home.symbolQuote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.quoteapi.App
import com.example.quoteapi.Model.Response
import com.example.quoteapi.R
import com.example.quoteapi.UI.Home.di.DaggerHomeComponent
import com.example.quoteapi.UI.Home.di.symbol.DaggerQuoteComponent
import com.example.quoteapi.UI.Home.di.symbol.QuoteHomeModule
import com.example.quoteapi.di.AppComponent
import kotlinx.android.synthetic.main.activity_symbol_quote.*
import javax.inject.Inject

class SymbolQuoteActivity : AppCompatActivity(), SymbolHomeContract.View {


    @Inject
    lateinit var quoteHomePresenter: SymbolHomeContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symbol_quote)


        DaggerQuoteComponent.builder()
            .appComponent((application as App).getComponent())
            .quoteHomeModule(QuoteHomeModule(this))
            .build()
            .inject(this)


        btnFindSymbolQuote.setOnClickListener {
            quoteHomePresenter.getSymbolQuote(etSymbol.text.toString())

        }
    }


    override fun showResults(results: Response) {

        tvSymbol.text = results.symbol
        tvCompanyName.text = results.companyName
        tvLatestPrice.text = results.latestPrice.toString()


    }

    override fun showError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

