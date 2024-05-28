package com.example.onthetableapp.data.remote.entity

import com.google.gson.annotations.SerializedName

data class MealsArrayListModel (
    @SerializedName("meals" ) var meals : ArrayList<Meals> = arrayListOf()
)
