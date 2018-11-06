package com.example.joao.chucknorrisapp.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Context
import android.util.Log
import com.example.joao.chucknorrisapp.callbacks.JokeBoundaryCallback
import com.example.joao.chucknorrisapp.db.dao.JokesDao
import com.example.joao.chucknorrisapp.pojo.ApiResponse
import com.example.joao.chucknorrisapp.pojo.ApiResponse3
import com.example.joao.chucknorrisapp.pojo.Joke
import com.example.joao.chucknorrisapp.webservices.Webservices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import javax.inject.Inject


class JokeRepository @Inject constructor(private var services: Webservices, private val jokesDao: JokesDao, private val executor: Executor) {

    fun getAllJokes(): LiveData<List<Joke>> {

        executor.execute {

            if(jokesDao.getNrJokes() == 0)
                getAllJokesFromServer()
        }

        return jokesDao.getAllJokes()
    }

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

    fun getJokesForCategory(cat: String, context: Context?): LiveData<PagedList<Joke>> {

        executor.execute {

            if(jokesDao.getNrJokes() == 0)
                getAllJokesFromServer()
        }

        val factory: DataSource.Factory<Int, Joke> = jokesDao.getJokesForCategory(cat)

        val pagedListBuilder: LivePagedListBuilder<Int, Joke> = LivePagedListBuilder<Int, Joke>(factory, 10).setBoundaryCallback(JokeBoundaryCallback(context!!))

        return pagedListBuilder.build()
    }


    private fun getAllJokesFromServer(){
        services.getAllJokes().enqueue(object : Callback<ApiResponse3> {
            override fun onFailure(call: Call<ApiResponse3>?, t: Throwable?) {
                Log.d("JMF-Error", t.toString())
            }

            override fun onResponse(call: Call<ApiResponse3>?, response: Response<ApiResponse3>?) {
                if (response != null && response.isSuccessful) {

                    val apiResponse: ApiResponse3? = response.body()

                    for(jk in apiResponse!!.value){

                        val joke = Joke(jk.id, jk.joke, jk.categories)

                        executor.execute { jokesDao.insert(joke) }
                    }
                }
            }
        })
    }

}