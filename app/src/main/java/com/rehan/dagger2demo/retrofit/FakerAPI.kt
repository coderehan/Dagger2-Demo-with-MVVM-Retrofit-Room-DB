package com.rehan.dagger2demo.retrofit

import com.rehan.dagger2demo.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}