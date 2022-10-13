package com.rehan.dagger2demo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rehan.dagger2demo.models.Product

// Here we have to access our DAO
@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDAO() : FakerDAO
}