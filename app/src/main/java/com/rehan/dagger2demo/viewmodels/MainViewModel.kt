package com.rehan.dagger2demo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rehan.dagger2demo.models.Product
import com.rehan.dagger2demo.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel  // This annotation will create factory behind the scenes amd in hilt we don't need to create factory for view models
class MainViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {     // Here we cannot use @Inject constructor() because this MainViewModel class is created by ViewModelProvider. It means ViewModelProvider will create object for us

    val productsLiveData : LiveData<List<Product>>  // Response of LiveData is in List of Products
    get() = repository.products

    // init block to launch coroutines
    init {
        viewModelScope.launch {
            repository.getProducts()        // Here we will call function of our repository class
        }
    }
}