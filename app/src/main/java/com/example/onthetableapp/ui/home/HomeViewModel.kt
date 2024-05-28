package com.example.onthetableapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onthetableapp.data.remote.entity.MealsArrayListModel
import com.example.onthetableapp.data.remote.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val mealsMutableLiveData: MutableLiveData<MealsArrayListModel> = MutableLiveData<MealsArrayListModel>()
    val mealsYouMightLikeMutableLiveData: MutableLiveData<MealsArrayListModel> = MutableLiveData<MealsArrayListModel>()
//    val arrayListModel: ArrayList<MealsArrayListModel> = ArrayList<MealsArrayListModel>()

    fun getMealsArraylist() {
        RetrofitClient.getMealsArrayList().enqueue(object : Callback<MealsArrayListModel> {
            override fun onResponse(
                p0: Call<MealsArrayListModel>,
                p1: Response<MealsArrayListModel>
            ) {
                mealsMutableLiveData.value = p1.body()
            }

            override fun onFailure(p0: Call<MealsArrayListModel>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getSuggestedMeals(){
        RetrofitClient.getSuggestedMealsArrayList().enqueue(object : Callback<MealsArrayListModel>{
            override fun onResponse(
                p0: Call<MealsArrayListModel>,
                p1: Response<MealsArrayListModel>
            ) {
                mealsYouMightLikeMutableLiveData.value = p1.body()
//                var mealImageUrl : String? = p1.body()?.meals?.get(0)?.strMeal
//                arrayListModel = p1.body().meals
            }

            override fun onFailure(p0: Call<MealsArrayListModel>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}