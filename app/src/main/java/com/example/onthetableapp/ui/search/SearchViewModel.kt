package com.example.onthetableapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onthetableapp.data.remote.entity.SearchCategoryList
import com.example.onthetableapp.data.remote.entity.SearchCuisine
import com.example.onthetableapp.data.remote.entity.SearchCuisineList
import com.example.onthetableapp.data.remote.entity.SearchIngredientList
import com.example.onthetableapp.data.remote.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    val cuisineMutableLiveData: MutableLiveData<SearchCuisineList> = MutableLiveData<SearchCuisineList>()
    val categoryMutableLiveData: MutableLiveData<SearchCategoryList> = MutableLiveData<SearchCategoryList>()
    val ingredientMutableLiveData: MutableLiveData<SearchIngredientList> = MutableLiveData<SearchIngredientList>()

    fun getCuisine(){
        RetrofitClient.getCuisine().enqueue(object : Callback<SearchCuisineList>{
            override fun onResponse(p0: Call<SearchCuisineList>, p1: Response<SearchCuisineList>) {
                cuisineMutableLiveData.value = p1.body()
            }

            override fun onFailure(p0: Call<SearchCuisineList>, p1: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

    fun getCategory(){
        RetrofitClient.getCategory().enqueue(object : Callback<SearchCategoryList>{
            override fun onResponse(
                p0: Call<SearchCategoryList>,
                p1: Response<SearchCategoryList>
            ) {
                categoryMutableLiveData.value = p1.body()
            }

            override fun onFailure(p0: Call<SearchCategoryList>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getIngredient(){
        RetrofitClient.getIngredient().enqueue(object : Callback<SearchIngredientList> {
            override fun onResponse(
                p0: Call<SearchIngredientList>,
                p1: Response<SearchIngredientList>
            ) {
                ingredientMutableLiveData.value = p1.body()
            }

            override fun onFailure(p0: Call<SearchIngredientList>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}