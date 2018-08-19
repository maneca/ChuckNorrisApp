package com.example.joao.chucknorrisapp.dependencyInjection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.joao.chucknorrisapp.viewmodel.JokeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(JokeViewModel::class)
    abstract fun bindJokeViewModel(jokeViewModel: JokeViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory
}