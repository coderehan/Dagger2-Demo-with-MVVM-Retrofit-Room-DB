package com.rehan.dagger2demo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rehan.dagger2demo.db.FakerDB
import com.rehan.dagger2demo.models.Product
import com.rehan.dagger2demo.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI, private val fakerDB: FakerDB) {

    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>>
    get() = _products

    suspend fun getProducts(){
        val result = fakerAPI.getProducts()
        if(result.isSuccessful && result.body() != null){
            // First we will get data from API and we will store those data in room database and then we will sow in UI
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }

}