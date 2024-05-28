package com.example.onthetableapp.data.remote.network

import com.example.onthetableapp.data.remote.entity.MealsArrayListModel
import retrofit2.Call
import retrofit2.http.GET

interface MealsApiInterface {

    @GET("random.php")
    fun getMeal() : Call<MealsArrayListModel>

}