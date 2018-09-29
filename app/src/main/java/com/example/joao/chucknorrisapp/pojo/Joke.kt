package com.example.joao.chucknorrisapp.pojo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName="jokes")
data class Joke(@PrimaryKey(autoGenerate = false) @ColumnInfo(name="joke_id") var id: Int, @ColumnInfo(name="joke") var joke: String, @ColumnInfo(name="categories") var categories: List<String>) {

}