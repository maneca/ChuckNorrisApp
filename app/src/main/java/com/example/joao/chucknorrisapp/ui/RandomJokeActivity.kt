package com.example.joao.chucknorrisapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.joao.chucknorrisapp.R
import com.example.joao.chucknorrisapp.dependencyInjection.Injectable
import com.example.joao.chucknorrisapp.dependencyInjection.ViewModelFactory
import com.example.joao.chucknorrisapp.viewmodel.JokeViewModel
import com.google.android.gms.security.ProviderInstaller
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.random_joke_layout.*
import javax.inject.Inject


class RandomJokeActivity : AppCompatActivity(), Injectable, View.OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.random_joke_layout)
        AndroidInjection.inject(this)

        ProviderInstaller.installIfNeeded(applicationContext)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(JokeViewModel::class.java)
        viewModel.getRandomJoke().observe(this, Observer { joke ->

            joke_text.text = joke!!
        })

        button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when (view!!.id) {
            R.id.button -> viewModel.getRandomJoke()
            else -> Log.d("JMF-Main", "error")
        }
    }
}
