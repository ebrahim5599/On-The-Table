package com.example.onthetableapp.data.remote.entity

import com.google.gson.annotations.SerializedName

data class HomeMealsList (
    @SerializedName("meals" ) var meals : ArrayList<HomeMeals> = arrayListOf()
)
