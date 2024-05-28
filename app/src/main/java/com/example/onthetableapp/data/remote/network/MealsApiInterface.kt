package com.example.onthetableapp.data.remote.network

import com.example.onthetableapp.data.remote.entity.MealsArrayListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApiInterface {

    @GET("random.php")
    fun getMeal() : Call<MealsArrayListModel>

    @GET("search.php")
    fun getSuggestedMeals(@Query("f") randomChar :Char) : Call<MealsArrayListModel>

}