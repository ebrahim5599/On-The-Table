package com.example.onthetableapp.data.remote.entity

import com.google.gson.annotations.SerializedName


data class SearchCategoryList (

  @SerializedName("categories" ) var categories : ArrayList<SearchCategory> = arrayListOf()

)