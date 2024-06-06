package com.example.onthetableapp.data.remote.entity

import com.google.gson.annotations.SerializedName


data class SearchIngredientList (

  @SerializedName("meals" ) var meals : ArrayList<SearchIngredient> = arrayListOf()

)