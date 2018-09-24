package com.example.joao.chucknorrisapp.repository

import android.arch.lifecycle.LiveData
import com.example.joao.chucknorrisapp.db.dao.CategoriesDao
import com.example.joao.chucknorrisapp.pojo.Category
import com.example.joao.chucknorrisapp.webservices.Webservices
import android.util.Log
import com.example.joao.chucknorrisapp.pojo.ApiResponse2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CategoriesRepository @Inject constructor(private var services: Webservices, private val categoriesDao: CategoriesDao) {


    fun getCategories(): LiveData<List<Category>> {

        if(categoriesDao.getNrCategories() == 0){
            getCategoriesfromServer()
        }

        return categoriesDao.getAllCategories()
    }

    private fun getCategoriesfromServer(){

        services.getCategories().enqueue(object: Callback<ApiResponse2> {
            override fun onFailure(call: Call<ApiResponse2>, t: Throwable) {
                Log.d("Category-error", t.toString())
            }

            override fun onResponse(call: Call<ApiResponse2>, response: Response<ApiResponse2>) {

                if (response.isSuccessful) {

                    val apiResponse: ApiResponse2? = response.body()

                    for(cat in apiResponse!!.value){
                        val category = Category(cat)
                        categoriesDao.insert(category)
                    }
                }
            }

        })
    }
}