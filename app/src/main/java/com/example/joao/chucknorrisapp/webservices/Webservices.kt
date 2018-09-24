package com.example.joao.chucknorrisapp.webservices

import com.example.joao.chucknorrisapp.pojo.ApiResponse
import com.example.joao.chucknorrisapp.pojo.ApiResponse2
import retrofit2.Call
import retrofit2.http.GET

interface Webservices {

    @GET("jokes/random")
    fun getRandomJoke(): Call<ApiResponse>

    @GET("categories")
    fun getCategories(): Call<ApiResponse2>

    @GET("jokes")
    fun getAllJokes(): Call<ApiResponse>
}