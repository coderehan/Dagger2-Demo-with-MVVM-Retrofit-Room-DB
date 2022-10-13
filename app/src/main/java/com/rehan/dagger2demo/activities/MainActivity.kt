package com.rehan.dagger2demo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rehan.dagger2demo.R
import com.rehan.dagger2demo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    // Accessing TextView ID from XML
    private val products: TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This is how we create ViewModel object
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // We have LiveData inside MainViewModel class and we will observe that LiveData
        mainViewModel.productsLiveData.observe(this, Observer {
            products.text =
                it.joinToString { x -> x.title + "\n\n" }        //joinToString is the function of list and here we are just accessing title only
        })
    }
}