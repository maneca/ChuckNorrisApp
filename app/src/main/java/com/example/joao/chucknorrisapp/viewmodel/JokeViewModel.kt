package com.example.joao.chucknorrisapp.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.joao.chucknorrisapp.repository.JokeRepository
import javax.inject.Inject

class JokeViewModel : ViewModel {

    private var repo : JokeRepository

    @Inject
    constructor(repository: JokeRepository){

        repo = repository
    }

    fun init() {
        Log.d("JMF", "passei aqui")
        repo.getRandomJoke()
    }


}