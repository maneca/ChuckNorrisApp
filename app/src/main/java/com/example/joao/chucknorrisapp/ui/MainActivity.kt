package com.example.joao.chucknorrisapp.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.joao.chucknorrisapp.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        AndroidInjection.inject(this)

        random_btn.setOnClickListener(this)
        categories_btn.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.random_btn -> {
                val intent = Intent(this, RandomJokeActivity::class.java)
                startActivity(intent)
            }
            R.id.categories_btn -> {
                val intent = Intent(this, CategoriesActivity::class.java)
                startActivity(intent)
            }
            else -> Log.d("JMF-Main", "error")
        }
    }
}