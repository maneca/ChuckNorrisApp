package com.example.joao.chucknorrisapp.dependencyInjection

import com.example.joao.chucknorrisapp.ui.MainActivity
import com.example.joao.chucknorrisapp.ui.RandomJokeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeRandomJokeActivity(): RandomJokeActivity


    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

}