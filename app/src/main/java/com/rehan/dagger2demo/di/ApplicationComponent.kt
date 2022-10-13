package com.rehan.dagger2demo.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.rehan.dagger2demo.activities.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    // Accessing map from ViewModelModule class
    // Here key will be our class name and value will be our view model
    fun getMap() : Map<Class<*>, ViewModel>

    // Factory is used to create objects
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent         // It means we are binding the context inside component i.e. Whenever dagger needs context, it will use this
    }
}