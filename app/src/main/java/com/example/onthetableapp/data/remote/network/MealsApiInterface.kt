package com.example.onthetableapp.data.remote.network

import com.example.onthetableapp.data.remote.entity.HomeMealsList
import com.example.onthetableapp.data.remote.entity.SearchCategoryList
import com.example.onthetableapp.data.remote.entity.SearchCuisine
import com.example.onthetableapp.data.remote.entity.SearchCuisineList
import com.example.onthetableapp.data.remote.entity.SearchIngredientList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApiInterface {

    @GET("random.php")
    fun getMeal() : Call<HomeMealsList>

    @GET("search.php")
    fun getSuggestedMeals(@Query("f") randomChar :Char) : Call<HomeMealsList>

    @GET("list.php?a=list")
    fun getCountryCuisine() : Call<SearchCuisineList>

    @GET("categories.php")
    fun getCategory() : Call<SearchCategoryList>

    @GET("list.php?i=list")
    fun getIngredients() : Call<SearchIngredientList>
}