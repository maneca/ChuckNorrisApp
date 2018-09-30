package com.example.joao.chucknorrisapp

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.joao.chucknorrisapp.db.AppDatabase
import com.example.joao.chucknorrisapp.pojo.Joke
import org.junit.After
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DaoTest {

    private lateinit var database : AppDatabase

    @Before
    fun initDB(){
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase::class.java).build()
    }

    @After
    fun closeDB(){
        database.close()
    }


    @Test
    fun insertJokeSaveData(){
        val cachedJoke = Joke(1, "a", listOf("explicit"))

        database.jokesDao().insert(cachedJoke)

        assert(database.jokesDao().getNrJokes() > 0)
    }

    @Test
    fun getJokeRetrieveData(){

        val joke1 = Joke(1, "a", listOf("explicit"))
        val joke2 = Joke(2, "b", listOf("explicit"))
        val joke3 = Joke(3, "c", listOf("explicit"))

        val jokes = listOf(joke1, joke2, joke3)

        jokes.forEach { database.jokesDao().insert(it) }

        val savedJokes = database.jokesDao().getAllJokes()

        assert( jokes == savedJokes)

    }

    @Test
    fun deleteJokesClearData(){

        val cachedJoke = Joke(1, "a", listOf("explicit"))

        database.jokesDao().insert(cachedJoke)

        database.jokesDao().deleteAll()

        assert(database.jokesDao().getNrJokes() == 0)
    }
}
