package com.example.joao.chucknorrisapp.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.joao.chucknorrisapp.repository.JokeRepository
import javax.inject.Inject

class JokeViewModel @Inject constructor(repository: JokeRepository) : ViewModel() {

    private var repo: JokeRepository = repository
    private var joke: MutableLiveData<String> = MutableLiveData()


    fun getRandomJoke(): LiveData<String> {
        repo.getRandomJoke(joke)

        return this.joke
    }

    fun getAllJokes() = repo.getAllJokes()

    fun getJokesForCategory(cat: String, context: Context?) = repo.getJokesForCategory(cat, context)

}