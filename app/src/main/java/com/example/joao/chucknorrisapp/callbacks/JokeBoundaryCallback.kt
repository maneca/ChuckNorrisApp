package com.example.joao.chucknorrisapp.callbacks

import android.arch.paging.PagedList
import android.content.Context
import android.widget.Toast
import com.example.joao.chucknorrisapp.pojo.Joke

class JokeBoundaryCallback(val context: Context): PagedList.BoundaryCallback<Joke>(){

    override fun onItemAtEndLoaded(itemAtEnd: Joke) {
        Toast.makeText(context, "Reached the end of the list", Toast.LENGTH_SHORT).show()
    }

}