package com.example.quoteapi.Network

import com.example.quoteapi.Model.QuoteResponse
import com.example.quoteapi.Model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QuoteService {
    @GET(STOCK_ENDPOINT)
    fun getStocksQuote(): Observable<List<Response>>

   @GET("stock/{symbol}/quote")
    fun getSymbolQuote(@Path("symbol") symbol: String): Observable<Response>
}