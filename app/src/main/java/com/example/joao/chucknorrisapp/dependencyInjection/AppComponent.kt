package com.example.joao.chucknorrisapp.dependencyInjection

import android.app.Application
import com.example.joao.chucknorrisapp.ChuckNorrisApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ActivityModule::class, NetworkModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: ChuckNorrisApp)
}