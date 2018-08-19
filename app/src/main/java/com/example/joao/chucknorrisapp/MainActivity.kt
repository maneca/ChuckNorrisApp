package com.example.joao.chucknorrisapp

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.joao.chucknorrisapp.dependencyInjection.Injectable
import com.example.joao.chucknorrisapp.dependencyInjection.ViewModelFactory
import com.example.joao.chucknorrisapp.viewmodel.JokeViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(JokeViewModel::class.java)
        viewModel.init()
    }
}
