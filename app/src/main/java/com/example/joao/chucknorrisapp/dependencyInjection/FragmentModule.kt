package com.example.joao.chucknorrisapp.dependencyInjection

import com.example.joao.chucknorrisapp.ui.CategoriesFragment
import com.example.joao.chucknorrisapp.ui.ListJokesFragment
import com.example.joao.chucknorrisapp.ui.MainViewFragment
import com.example.joao.chucknorrisapp.ui.RandomJokeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainViewFragment(): MainViewFragment

    @ContributesAndroidInjector
    internal abstract fun contributeRandomJokeFragment(): RandomJokeFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCategoriesFragment(): CategoriesFragment

    @ContributesAndroidInjector
    internal abstract fun contributeListJokesFragment(): ListJokesFragment
}