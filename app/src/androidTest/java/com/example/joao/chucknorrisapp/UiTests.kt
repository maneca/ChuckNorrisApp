package com.example.joao.chucknorrisapp

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import com.example.joao.chucknorrisapp.ui.MainActivity
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import org.hamcrest.Matchers.allOf
import android.support.test.espresso.contrib.RecyclerViewActions
import com.example.joao.chucknorrisapp.adapters.JokesPagedAdapter
import kotlinx.android.synthetic.main.recyclerview_layout.*


@LargeTest
@RunWith(AndroidJUnit4::class)
class UiTests {

    @Rule @JvmField
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    fun withRecyclerView(recyclerViewID: Int): RecyclerViewMatcher{
        return RecyclerViewMatcher(recyclerViewID)
    }

    @Test
    fun randomJoke() {

        onView(withId(R.id.random_btn)).perform(click())

        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val confirmBtn = onView(allOf(withText(R.string.next), isDisplayed()))
        confirmBtn.perform(click())

        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    @Test
    fun checkCategories(){

        onView(withId(R.id.categories_btn)).perform(click())

        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(withRecyclerView(R.id.recyclerview).atPosition(0)).check(matches(hasDescendant(withText("Explicit"))))

        onView(withRecyclerView(R.id.recyclerview).atPosition(0)).perform(click())

        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(withRecyclerView(R.id.recyclerview).atPosition(1)).check(matches(hasDescendant(withText("Chuck Norris lost his virginity before his dad did."))))

        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.scrollToPosition<JokesPagedAdapter.PersonViewHolder>(mActivityRule.activity.recyclerview.adapter!!.itemCount -1))

        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        onView(withRecyclerView(R.id.recyclerview).atPosition(mActivityRule.activity.recyclerview.adapter!!.itemCount -2)).check(matches(hasDescendant(withText("China lets Chuck Norris search for porn on Google."))))

    }


}
