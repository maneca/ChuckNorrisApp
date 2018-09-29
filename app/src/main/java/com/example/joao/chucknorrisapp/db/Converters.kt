package com.example.joao.chucknorrisapp.db

import android.arch.persistence.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromArrayString(value: List<String>): String{

        var categories = ""

        for(cat in value){
            categories += value + ","
        }

        return categories
    }

    @TypeConverter
    fun toArrayString(value : String): List<String>{

        val categories = mutableListOf<String>()

        for(s in value.split(","))
            categories.plus(s)

        return categories
    }
}