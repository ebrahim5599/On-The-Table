package com.example.onthetableapp.data.remote.entity

import com.google.gson.annotations.SerializedName


data class SearchCuisine (

  @SerializedName("meals" ) var meals : ArrayList<SearchMeals> = arrayListOf()

)