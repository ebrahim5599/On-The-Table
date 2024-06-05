package com.example.onthetableapp.data.remote.entity

import com.google.gson.annotations.SerializedName


data class SearchCuisineList (

  @SerializedName("meals" ) var meals : ArrayList<SearchCuisine> = arrayListOf()

)