package com.example.joao.chucknorrisapp.dependencyInjection

import com.example.joao.chucknorrisapp.webservices.Webservices
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module(includes = arrayOf(ViewModelModule::class))
class NetworkModule {


    @Singleton @Provides
    fun provideOKHttpClient(): OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)
        client.connectTimeout(60, TimeUnit.SECONDS)
        client.readTimeout(45, TimeUnit.SECONDS)
        client.writeTimeout(15, TimeUnit.SECONDS)

        return client.build()
    }


    @Singleton
    @Provides
    fun provideClientsWebservices(client: OkHttpClient): Webservices {
        return Retrofit.Builder()
                .baseUrl("https://api.icndb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(Webservices::class.java)
    }

    @Singleton
    @Provides
    fun provideExecutor() : Executor{
        return Executors.newSingleThreadExecutor()
    }
    
}

