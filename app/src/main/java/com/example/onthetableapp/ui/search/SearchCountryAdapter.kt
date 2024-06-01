package com.example.onthetableapp.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onthetableapp.R
import com.example.onthetableapp.data.remote.entity.SearchMeals

class SearchCountryAdapter(private val countryList : ArrayList<SearchMeals>): RecyclerView.Adapter<SearchCountryAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchCountryAdapter.CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_search_row_layout, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchCountryAdapter.CountryViewHolder, position: Int) {
        holder.countryTextView.text = countryList[position].strArea
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryTextView : TextView = itemView.findViewById(R.id.country_TextView_search)
    }
}