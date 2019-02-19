package com.example.quoteapi.UI.Home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.quoteapi.App
import com.example.quoteapi.Model.Response
import com.example.quoteapi.R
import com.example.quoteapi.UI.Home.di.DaggerHomeComponent

import com.example.quoteapi.UI.Home.di.HomeModules
import com.example.quoteapi.UI.Home.symbolQuote.SymbolQuoteActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),QuoteListContract.View {

    private val quoteListAdapter = QuoteListAdapter()
    @Inject
    lateinit var homePresenter:QuoteListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModules(HomeModules(this))
            .build()
            .inject(this)



        rvQuoteList.layoutManager = LinearLayoutManager(this)
        rvQuoteList.adapter = quoteListAdapter
        homePresenter.getQuoteList()

        btnFindQuote.setOnClickListener {
            startActivity(Intent(this,SymbolQuoteActivity::class.java))
        }

    }

    override fun showResults(results: List<Response>) {
        quoteListAdapter.setData(results)
        }

    override fun showError(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}
