package com.example.joao.chucknorrisapp.dependencyInjection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


class ViewModelFactory : ViewModelProvider.Factory{

    private lateinit var creators: Map<Class<out ViewModel>, Provider<ViewModel>>

    @Inject
    fun ViewModelFactory(creators: Map<Class<out ViewModel>, Provider<ViewModel>>) {
        this.creators = creators
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        if (creator == null) throw IllegalArgumentException("unknown model class " + modelClass)

        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}