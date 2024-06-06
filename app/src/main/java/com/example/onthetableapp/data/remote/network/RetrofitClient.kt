package com.example.onthetableapp.data.remote.network

import com.example.onthetableapp.data.remote.entity.HomeMealsList
import com.example.onthetableapp.data.remote.entity.SearchCategoryList
import com.example.onthetableapp.data.remote.entity.SearchCuisine
import com.example.onthetableapp.data.remote.entity.SearchCuisineList
import com.example.onthetableapp.data.remote.entity.SearchIngredientList
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

    fun getMealsArrayList() : Call<HomeMealsList> {
        return apiInterface.getMeal()
    }

    private fun getRandomCharExceptSomeCharacters() : Char{
        // except q-u-x-z
        val allowedChars = ('a' .. 'z').filter { it !in listOf('q', 'u', 'x', 'z') }
        return allowedChars.random()
    }
    fun getSuggestedMealsArrayList() : Call<HomeMealsList>{
        return apiInterface.getSuggestedMeals(getRandomCharExceptSomeCharacters())
    }

    fun getCuisine() : Call<SearchCuisineList>{
        return apiInterface.getCountryCuisine()
    }

    fun getCategory() : Call<SearchCategoryList>{
        return apiInterface.getCategory()
    }

    fun getIngredient() : Call<SearchIngredientList> {
        return apiInterface.getIngredients()
    }

}