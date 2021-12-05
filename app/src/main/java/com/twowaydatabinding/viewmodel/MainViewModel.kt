package com.twowaydatabinding.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twowaydatabinding.api.RetrofitHelper
import com.twowaydatabinding.model.Hero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val mutableHeroData : MutableLiveData<List<Hero>> = MutableLiveData()
    val errorData : MutableLiveData<String> = MutableLiveData()


    init {
        val apiService = RetrofitHelper.getApiService().getHeroes()

        apiService.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                if (response.code() == 200){
                    mutableHeroData.postValue(response.body())
                }
                else
                    errorData.postValue(response.errorBody().toString())
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                errorData.postValue(t.message)
            }

        })
    }
}