package com.rehan.dagger2demo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rehan.dagger2demo.R
import com.rehan.dagger2demo.application.FakerApplication
import com.rehan.dagger2demo.viewmodels.MainViewModel
import com.rehan.dagger2demo.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    // Whenever we want to initialize any fields through dagger, we have to use @Inject annotation and then we have to initialize with component
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    // Accessing TextView ID from XML
    private val products: TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Wherever we use @Inject annotation for fields, we have to tell Dagger to initialize them and for that we have to use component
        // Accessing component
        (application as FakerApplication).applicationComponent.inject(this)

        val map = (application as FakerApplication).applicationComponent.getMap()

        // This is how we create ViewModel object
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        // We have LiveData inside MainViewModel class and we will observe that LiveData
        mainViewModel.productsLiveData.observe(this, Observer {
            products.text =
                it.joinToString { x -> x.title + "\n\n" }        //joinToString is the function of list and here we are just accessing title only
        })
    }
}