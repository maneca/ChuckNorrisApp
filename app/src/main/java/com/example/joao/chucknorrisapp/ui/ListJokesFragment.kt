package com.example.joao.chucknorrisapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joao.chucknorrisapp.R
import com.example.joao.chucknorrisapp.adapters.JokesPagedAdapter
import com.example.joao.chucknorrisapp.dependencyInjection.Injectable
import com.example.joao.chucknorrisapp.dependencyInjection.ViewModelFactory
import com.example.joao.chucknorrisapp.viewmodel.JokeViewModel
import kotlinx.android.synthetic.main.recyclerview_layout.*
import javax.inject.Inject

class ListJokesFragment: Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: JokeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.recyclerview_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = JokesPagedAdapter(context)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(JokeViewModel::class.java)

        val bundle = arguments
        viewModel.getJokesForCategory(bundle?.getString("category")!!).observe(this, Observer { it ->

            (recyclerview.adapter as JokesPagedAdapter).submitList(it)
        //    Log.d("JMF", it.toString())
        })

    }
}