package com.rehan.dagger2demo.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// Here Product is the table name
@Entity
data class Product(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)   // The reason why we tell false here is we because we are getting this id from api third party and we have no control over it
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)