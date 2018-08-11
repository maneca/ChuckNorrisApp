package com.example.joao.chucknorrisapp.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.joao.chucknorrisapp.repository.JokeRepository
import javax.inject.Inject

class JokeViewModel : ViewModel {

    private var repo : JokeRepository

    @Inject
    constructor(repository: JokeRepository){

        repo = repository
    }


}