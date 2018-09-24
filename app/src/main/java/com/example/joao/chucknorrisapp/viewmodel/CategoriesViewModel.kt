package com.example.joao.chucknorrisapp.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject
import com.example.joao.chucknorrisapp.pojo.Category
import com.example.joao.chucknorrisapp.repository.CategoriesRepository


class CategoriesViewModel @Inject constructor(repo: CategoriesRepository): ViewModel() {

    private var allCategoriesLiveData: LiveData<List<Category>>? = null
    private var repository = repo

    init {
        allCategoriesLiveData = repository.getCategories()
    }

    fun getAllCategories() = allCategoriesLiveData
}
