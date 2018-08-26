package com.example.joao.chucknorrisapp.repository

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.joao.chucknorrisapp.pojo.ApiResponse
import com.example.joao.chucknorrisapp.webservices.Webservices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import javax.inject.Inject


class JokeRepository @Inject constructor(private final var services: Webservices, private final var executor: Executor) {

    fun getRandomJoke(joke: MutableLiveData<String>) {

        services.getRandomJoke().enqueue(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>?, t: Throwable?) {
                Log.d("JMF-Error", t.toString())
            }

            override fun onResponse(call: Call<ApiResponse>?, response: Response<ApiResponse>?) {
                if (response != null && response.isSuccessful) {

                    val apiResponse: ApiResponse? = response.body()

                    joke.value = apiResponse!!.value.joke
                }
            }
        })


    }

}