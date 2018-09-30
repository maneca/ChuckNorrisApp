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

class JokesPagedAdapter(private val context: Context?) : PagedListAdapter<Joke, JokesPagedAdapter.PersonViewHolder>(JokeDiffCallback()) {

    override fun onBindViewHolder(holderPerson: PersonViewHolder, position: Int) {
        val person = getItem(position)

        if (person == null) {
            holderPerson.clear()
        } else {
            holderPerson.bind(person)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {

        return PersonViewHolder(LayoutInflater.from(context).inflate(R.layout.item_joke,
                parent, false))
    }


    class PersonViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private var tvName: TextView = view.joke_text

        fun bind(joke: Joke) {
            tvName.text = joke.joke
        }

        fun clear() {
            tvName.text = null
        }

    }
}