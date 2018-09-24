package com.example.joao.chucknorrisapp.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import com.example.joao.chucknorrisapp.pojo.Category

@Dao
interface CategoriesDao {

    @Query("SELECT * FROM categories")
    fun getAllCategories(): LiveData<List<Category>>

    @Query("SELECT COUNT(*) FROM categories")
    fun getNrCategories(): Int

    @Insert(onConflict = IGNORE)
    fun insert(cat: Category)

    @Query("DELETE FROM categories")
    fun deleteAll()

}