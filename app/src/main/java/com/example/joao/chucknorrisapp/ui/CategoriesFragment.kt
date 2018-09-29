package com.example.joao.chucknorrisapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.joao.chucknorrisapp.R
import com.example.joao.chucknorrisapp.adapters.CategoriesAdapter
import com.example.joao.chucknorrisapp.callbacks.CategoriesCallbacks
import com.example.joao.chucknorrisapp.dependencyInjection.Injectable
import com.example.joao.chucknorrisapp.dependencyInjection.ViewModelFactory
import com.example.joao.chucknorrisapp.viewmodel.CategoriesViewModel
import kotlinx.android.synthetic.main.recyclerview_layout.*
import javax.inject.Inject

class CategoriesFragment: Fragment(), Injectable, CategoriesCallbacks {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: CategoriesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.recyclerview_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = CategoriesAdapter(context, this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoriesViewModel::class.java)

        viewModel.getAllCategories()!!.observe(this, Observer { it ->

            (recyclerview.adapter as CategoriesAdapter).setDataset(it)
        })


    }

    override fun onCategoryClick(name: String) {

        val fm: FragmentManager = activity!!.supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()

        val listJokesFragment = ListJokesFragment()

        val bundle = Bundle()
        bundle.putString("category", name)
        listJokesFragment.arguments = bundle

        ft.addToBackStack(null)
        ft.replace(R.id.main_container, listJokesFragment, "Random")
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.commit()
    }
}

