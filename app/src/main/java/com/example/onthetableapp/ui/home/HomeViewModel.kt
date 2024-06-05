package com.example.onthetableapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onthetableapp.data.remote.entity.HomeMealsList
import com.example.onthetableapp.data.remote.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val mealsMutableLiveData: MutableLiveData<HomeMealsList> = MutableLiveData<HomeMealsList>()
    val mealsYouMightLikeMutableLiveData: MutableLiveData<HomeMealsList> = MutableLiveData<HomeMealsList>()

    fun getMealsArraylist() {
        RetrofitClient.getMealsArrayList().enqueue(object : Callback<HomeMealsList> {
            override fun onResponse(
                p0: Call<HomeMealsList>,
                p1: Response<HomeMealsList>
            ) {
                mealsMutableLiveData.value = p1.body()
            }

            override fun onFailure(p0: Call<HomeMealsList>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getSuggestedMeals(){
        RetrofitClient.getSuggestedMealsArrayList().enqueue(object : Callback<HomeMealsList>{
            override fun onResponse(
                p0: Call<HomeMealsList>,
                p1: Response<HomeMealsList>
            ) {
                mealsYouMightLikeMutableLiveData.value = p1.body()
            }

            override fun onFailure(p0: Call<HomeMealsList>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}