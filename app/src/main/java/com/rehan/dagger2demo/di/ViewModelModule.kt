package com.rehan.dagger2demo.di

import androidx.lifecycle.ViewModel
import com.rehan.dagger2demo.viewmodels.MainViewModel
import com.rehan.dagger2demo.viewmodels.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds     // Binds means we are using multi bindings i.e. we are binding mainViewModel object with ViewModel class
    @ClassKey(MainViewModel::class)     // The reason why we use @ClassKey is our return type is ViewModel class and we are binding multiple activity class with same ViewModel class
    @IntoMap   // We will add this ClassKey into Map just like HashMap
    abstract fun mainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds     //  Here we are binding mainViewModel2 object with ViewModel class
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun mainViewModel2(mainViewModel2: MainViewModel2) : ViewModel
}