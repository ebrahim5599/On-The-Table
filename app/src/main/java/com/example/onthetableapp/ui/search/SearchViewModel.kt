package com.example.onthetableapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onthetableapp.data.remote.entity.SearchMealsList
import com.example.onthetableapp.data.remote.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    val cuisineMutableLiveData: MutableLiveData<SearchMealsList> = MutableLiveData<SearchMealsList>()

    fun getCuisine(){
        RetrofitClient.getCuisine().enqueue(object : Callback<SearchMealsList>{
            override fun onResponse(p0: Call<SearchMealsList>, p1: Response<SearchMealsList>) {
                cuisineMutableLiveData.value = p1.body()
            }

            override fun onFailure(p0: Call<SearchMealsList>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}