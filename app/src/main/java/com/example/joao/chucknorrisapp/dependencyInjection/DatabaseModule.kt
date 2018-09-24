package com.example.joao.chucknorrisapp.dependencyInjection

import android.app.Application
import android.arch.persistence.room.Room
import com.example.joao.chucknorrisapp.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(app: Application) = Room.databaseBuilder(app, AppDatabase::class.java, "chuck.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Singleton @Provides
    fun provideCategoriesDao(appDatabase: AppDatabase) = appDatabase.categoriesDao()

}