package com.example.joao.chucknorrisapp.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.DataSource
import android.arch.paging.PagedList
import com.example.joao.chucknorrisapp.pojo.Joke
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

    fun getJokesForCategory(cat: String) = repo.getJokesForCategory(cat)

}