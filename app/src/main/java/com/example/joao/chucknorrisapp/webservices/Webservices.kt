package com.example.joao.chucknorrisapp.webservices

import com.example.joao.chucknorrisapp.pojo.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface Webservices {

    @GET("jokes/random")
    fun getRandomJoke(): Call<ApiResponse>
}