package com.twowaydatabinding.api

import com.twowaydatabinding.model.Hero
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @GET("marvel")
    fun getHeroes(): Call<List<Hero>>

}