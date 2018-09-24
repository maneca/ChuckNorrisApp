package com.example.joao.chucknorrisapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.joao.chucknorrisapp.db.dao.CategoriesDao
import com.example.joao.chucknorrisapp.pojo.Category

@Database(entities = arrayOf(Category::class),version = 2, exportSchema = false )
abstract class AppDatabase : RoomDatabase(){

    abstract fun categoriesDao(): CategoriesDao


}