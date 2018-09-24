package com.example.joao.chucknorrisapp.pojo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName="categories")
data class Category (@PrimaryKey(autoGenerate = false) @ColumnInfo(name = "name") var name : String) {


}