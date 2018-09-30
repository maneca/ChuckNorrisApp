package com.example.joao.chucknorrisapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joao.chucknorrisapp.R
import com.example.joao.chucknorrisapp.dependencyInjection.Injectable
import com.example.joao.chucknorrisapp.dependencyInjection.ViewModelFactory
import com.example.joao.chucknorrisapp.viewmodel.JokeViewModel
import kotlinx.android.synthetic.main.random_joke_layout.*
import javax.inject.Inject


class RandomJokeFragment : Fragment(), Injectable, View.OnClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: JokeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.random_joke_layout, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(JokeViewModel::class.java)
        viewModel.getRandomJoke().observe(this, Observer { joke ->

            joke_text.text = joke!!
        })

        next.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when (view!!.id) {
            R.id.next -> viewModel.getRandomJoke()
            else -> Log.d("JMF-Main", "error")
        }
    }
}
