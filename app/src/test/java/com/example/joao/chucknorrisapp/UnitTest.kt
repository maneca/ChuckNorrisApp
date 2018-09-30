package com.example.joao.chucknorrisapp

import android.widget.Button
import android.widget.TextView
import com.example.joao.chucknorrisapp.ui.MainActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UnitTest {

    @Test
    fun getRandomJoke(){

        val activity = Robolectric.setupActivity(MainActivity::class.java)

        val random: Button = activity.findViewById(R.id.random_btn)

        random.performClick()

        val joke_textview: TextView = activity.findViewById(R.id.joke_text)
        val joke = joke_textview.text

        val next: Button = activity.findViewById(R.id.next)
        next.performClick()

        val new_joke = joke_textview.text

        assert(!joke.equals(new_joke))

    }


}