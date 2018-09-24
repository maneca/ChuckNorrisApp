package com.example.joao.chucknorrisapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.joao.chucknorrisapp.R
import com.example.joao.chucknorrisapp.adapters.CategoriesAdapter
import com.example.joao.chucknorrisapp.dependencyInjection.Injectable
import com.example.joao.chucknorrisapp.dependencyInjection.ViewModelFactory
import com.example.joao.chucknorrisapp.viewmodel.CategoriesViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.categories_layout.*
import javax.inject.Inject

class CategoriesActivity: AppCompatActivity(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: CategoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories_layout)
        AndroidInjection.inject(this)

        all_categories.layoutManager = LinearLayoutManager(this)
        all_categories.adapter = CategoriesAdapter(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoriesViewModel::class.java)

        viewModel.getAllCategories()!!.observe(this, Observer { it ->

            Log.d("JMF-activity", it.toString())
            (all_categories.adapter as CategoriesAdapter).setDataset(it)
        })


    }
}

