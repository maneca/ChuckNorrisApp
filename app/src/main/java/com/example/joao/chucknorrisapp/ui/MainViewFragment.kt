package com.example.joao.chucknorrisapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joao.chucknorrisapp.R
import kotlinx.android.synthetic.main.main_view_layout.view.*

class MainViewFragment: Fragment(), View.OnClickListener {

    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.main_view_layout, container, false)

        view.random_btn.setOnClickListener(this)
        view.categories_btn.setOnClickListener(this)

        return view

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onClick(view: View?) {

        fm = activity!!.supportFragmentManager
        ft = fm.beginTransaction()
        ft.addToBackStack(null)

        when (view!!.id) {
            R.id.random_btn -> {
                ft.replace(R.id.main_container, RandomJokeFragment(), "Random")
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            }
            R.id.categories_btn -> {
                ft.replace(R.id.main_container, CategoriesFragment(), "Categories")
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            }
            else -> Log.d("JMF-Main", "error")
        }

        ft.commit()
    }
}