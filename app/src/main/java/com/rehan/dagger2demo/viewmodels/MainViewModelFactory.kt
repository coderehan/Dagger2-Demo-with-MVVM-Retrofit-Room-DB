package com.rehan.dagger2demo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.rehan.dagger2demo.repository.ProductRepository
import javax.inject.Inject

// This factory will create ViewModel object for us
class MainViewModelFactory @Inject constructor(private val map : Map<Class<*>, @JvmSuppressWildcards ViewModel>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return map[modelClass] as T
    }

}