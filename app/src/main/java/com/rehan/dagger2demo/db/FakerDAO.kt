package com.rehan.dagger2demo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rehan.dagger2demo.models.Product

// Inorder to access data from table, we use DAO
@Dao
interface FakerDAO {

    // This function is used to store data in database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products : List<Product>)

    // This function is used to display data from database
    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>
}