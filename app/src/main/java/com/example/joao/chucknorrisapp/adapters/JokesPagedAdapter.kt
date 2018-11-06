package com.example.joao.chucknorrisapp.adapters

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.joao.chucknorrisapp.R
import com.example.joao.chucknorrisapp.pojo.Joke
import kotlinx.android.synthetic.main.item_joke.view.*

class JokesPagedAdapter(private val context: Context?) : PagedListAdapter<Joke, JokesPagedAdapter.JokeViewHolder>(JokeDiffCallback()) {

    override fun onBindViewHolder(holderJoke: JokeViewHolder, position: Int) {
        val joke = getItem(position)

        if (joke == null) {
            holderJoke.clear()
        } else {
            holderJoke.bind(joke)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {

        return JokeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_joke, parent, false))
    }



    class JokeViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private var tvName: TextView = view.joke_text

        fun bind(joke: Joke) {
            tvName.text = joke.joke
        }

        fun clear() {
            tvName.text = null
        }

    }
}