package com.example.joao.chucknorrisapp.repository

import android.util.Log
import com.example.joao.chucknorrisapp.webservices.Webservices
import java.util.concurrent.Executor
import javax.inject.Inject


class JokeRepository {

    private final var services : Webservices
    private final var executor : Executor

    @Inject
    constructor(services: Webservices, executor: Executor){

        this.services = services
        this.executor = executor
    }

    fun getRandomJoke () {

        Log.d("JMF", "passei aqui2")

        executor.execute {

            try {
                val response = services.getRandomJoke().execute()

                Log.d("JMF", "" + response.toString())


            } catch (e: Exception) {
                Log.d("JMF", e.message)
                e.printStackTrace()
            }
        }

    }

}