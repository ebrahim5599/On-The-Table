package com.example.onthetableapp.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onthetableapp.R
import com.example.onthetableapp.data.remote.entity.SearchIngredient

class SearchIngredientAdapter(private val ingredientList: ArrayList<SearchIngredient>, private val context: Context?): RecyclerView.Adapter<SearchIngredientAdapter.IngredientViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchIngredientAdapter.IngredientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ingredient_item_search_fragment, parent, false)
        return IngredientViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchIngredientAdapter.IngredientViewHolder, position: Int) {
        val ingredientStr : String? = ingredientList[position].strIngredient
        holder.ingredientText.text = ingredientStr
        if (context != null) {
            Glide.with(context).load("https://www.themealdb.com/images/ingredients/$ingredientStr-Small.png")
                .into(holder.ingredientImage)
        }
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ingredientText : TextView = itemView.findViewById(R.id.textViewIngredientNameItem)
        val ingredientImage : ImageView = itemView.findViewById(R.id.imageViewIngredientImageItem)
    }
}