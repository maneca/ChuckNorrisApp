package com.example.joao.chucknorrisapp.db.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.joao.chucknorrisapp.pojo.Category
import com.example.joao.chucknorrisapp.pojo.Joke

@Dao
interface JokesDao {

    @Query("SELECT * FROM jokes")
    fun getAllJokes(): LiveData<List<Joke>>

    @Query ("SELECT * FROM  jokes WHERE categories LIKE '%' || :cat || '%'")
    fun getJokesForCategory(cat: String): DataSource.Factory<Int, Joke>

    @Query("SELECT COUNT(*) FROM jokes")
    fun getNrJokes(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(joke: Joke)

    @Query("DELETE FROM jokes")
    fun deleteAll()
}