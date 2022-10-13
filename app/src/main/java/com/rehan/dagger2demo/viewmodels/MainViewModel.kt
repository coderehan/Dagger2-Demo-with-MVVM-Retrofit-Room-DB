package com.rehan.dagger2demo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rehan.dagger2demo.models.Product
import com.rehan.dagger2demo.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

// When we have ViewModel class that needs input parameters in constructor, we have to create ViewModelFactory also
// Here we tell Dagger to create object for our ViewModel class
class MainViewModel @Inject constructor(private val repository: ProductRepository, private val randomize: Randomize) : ViewModel() {     // Here we cannot use @Inject constructor() because this MainViewModel class is created by ViewModelProvider. It means ViewModelProvider will create object for us

    val productsLiveData : LiveData<List<Product>>  // Response of LiveData is in List of Products
    get() = repository.products

    // init block to launch coroutines
    init {
        viewModelScope.launch {
            repository.getProducts()        // Here we will call function of our repository class
        }
    }

    class Randomize @Inject constructor(){
        fun doAction(){
            Log.d("CheezyCode", "Random Action")
        }
    }
}