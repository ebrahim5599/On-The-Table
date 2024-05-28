package com.example.onthetableapp.data.remote.network

import android.util.Log
import android.widget.Toast
import com.example.onthetableapp.data.remote.entity.MealsArrayListModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Random

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

    private fun getRandomCharExceptSomeCharacters() : Char{
        // except q-u-x-z
        val allowedChars = ('a' .. 'z').filter { it !in listOf('q', 'u', 'x', 'z') }
        return allowedChars.random()
    }
    fun getSuggestedMealsArrayList() : Call<MealsArrayListModel>{
        return apiInterface.getSuggestedMeals(getRandomCharExceptSomeCharacters())
    }
}