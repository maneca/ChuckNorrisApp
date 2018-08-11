package com.example.joao.chucknorrisapp.repository

import com.example.joao.chucknorrisapp.webservices.Webservices
import java.io.IOException
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

        executor.execute {

            try {
                val response = services.getRandomJoke().execute()

                if (response.errorBody() == null) {

                    //categories.postValue(response.body())
                }


            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    }

}