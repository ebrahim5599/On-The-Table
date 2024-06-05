package com.example.onthetableapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onthetableapp.data.remote.entity.SearchCuisine
import com.example.onthetableapp.data.remote.entity.SearchCuisineList
import com.example.onthetableapp.data.remote.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    val cuisineMutableLiveData: MutableLiveData<SearchCuisineList> = MutableLiveData<SearchCuisineList>()

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

}