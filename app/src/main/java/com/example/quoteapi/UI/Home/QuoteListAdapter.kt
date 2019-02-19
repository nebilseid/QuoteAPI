package com.example.quoteapi.UI.Home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quoteapi.Model.Response
import com.example.quoteapi.R
import kotlinx.android.synthetic.main.stock_item.view.*

class QuoteListAdapter : RecyclerView.Adapter<QuoteListAdapter.QuoteViewHolder>() {

    private val data = arrayListOf<Response>()

    fun setData (items: List<Response>){
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.stock_item, parent,false)
        return QuoteViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder:QuoteViewHolder, position: Int) {
        viewHolder.bind(data[position])

    }



class QuoteViewHolder (val view: View): RecyclerView.ViewHolder(view){
    fun bind (response: Response){
        view.tvLatestPrice.text = response.latestPrice.toString()
        view.tvSymbol.text = response.symbol
        view.tvCompanyName.text = response.companyName
    }
}}