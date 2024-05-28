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
}