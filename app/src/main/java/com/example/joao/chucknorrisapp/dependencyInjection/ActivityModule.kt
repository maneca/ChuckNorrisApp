package com.example.joao.chucknorrisapp.dependencyInjection

import com.example.joao.chucknorrisapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

}