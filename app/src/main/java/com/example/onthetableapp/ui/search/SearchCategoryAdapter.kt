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
import com.example.onthetableapp.data.remote.entity.SearchCategory

class SearchCategoryAdapter(private val categoryList: ArrayList<SearchCategory>, private val context: Context?): RecyclerView.Adapter<SearchCategoryAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchCategoryAdapter.CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_search_row_layout, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchCategoryAdapter.CategoryViewHolder, position: Int) {
        holder.categoryTextView.text = categoryList.get(position).strCategory
        if (context != null) {
            Glide.with(context).load(categoryList.get(position).strCategoryThumb)
                .into(holder.categoryImageView)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView : TextView = itemView.findViewById(R.id.categoryName_textView_card)
        val categoryImageView : ImageView =itemView.findViewById(R.id.category_imageView_card)
    }
}