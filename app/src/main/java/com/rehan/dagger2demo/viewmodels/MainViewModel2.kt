package com.rehan.dagger2demo.viewmodels

import androidx.lifecycle.ViewModel
import javax.inject.Inject

// Whenever we use @Inject annotation, it means we are telling Dagger to create object for us
class MainViewModel2 @Inject constructor(private val randomize: MainViewModel.Randomize) : ViewModel() {

    init {
        randomize.doAction()
    }
}