package com.example.joao.chucknorrisapp

import android.app.Activity
import android.app.Application
import com.example.joao.chucknorrisapp.dependencyInjection.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ChuckNorrisApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        AppInjector().init(this)
    }

    override fun activityInjector() : DispatchingAndroidInjector<Activity>  {
        return dispatchingActivityInjector
    }

}