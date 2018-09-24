package com.example.joao.chucknorrisapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joao.chucknorrisapp.R
import com.example.joao.chucknorrisapp.pojo.Category
import kotlinx.android.synthetic.main.item_cat.view.*

class CategoriesAdapter(val context : Context): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var mDataset: List<Category>

    init {
        mDataset = listOf()
    }


    override fun getItemCount(): Int {
        return mDataset.size
    }

    fun setDataset(addresses: List<Category>?) {

        mDataset = addresses!!

        notifyDataSetChanged()
    }


    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cat, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAnimalType?.text = mDataset.get(position).name
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvAnimalType = view.cat_text
    }
}