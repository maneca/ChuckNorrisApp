package com.example.joao.chucknorrisapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.joao.chucknorrisapp.db.dao.CategoriesDao
import com.example.joao.chucknorrisapp.db.dao.JokesDao
import com.example.joao.chucknorrisapp.pojo.Category
import com.example.joao.chucknorrisapp.pojo.Joke

@Database(entities = arrayOf(Category::class, Joke::class), version = 1, exportSchema = false )
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){

    abstract fun categoriesDao(): CategoriesDao

    abstract fun jokesDao(): JokesDao


}