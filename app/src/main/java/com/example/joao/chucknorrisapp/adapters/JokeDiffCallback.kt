package com.example.joao.chucknorrisapp.adapters

import android.support.v7.util.DiffUtil
import com.example.joao.chucknorrisapp.pojo.Joke

class JokeDiffCallback : DiffUtil.ItemCallback<Joke>() {

    override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem == newItem
    }
}