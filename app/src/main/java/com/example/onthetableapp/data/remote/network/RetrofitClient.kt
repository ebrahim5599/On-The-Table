package com.example.onthetableapp.data.remote.network

import com.example.onthetableapp.data.remote.entity.MealsArrayListModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL ="https://www.themealdb.com/api/json/v1/1/"
    private fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private val apiInterface: MealsApiInterface = getInstance().create(MealsApiInterface::class.java)

    fun getMealsArrayList() : Call<MealsArrayListModel> {
        return apiInterface.getMeal()
    }
}