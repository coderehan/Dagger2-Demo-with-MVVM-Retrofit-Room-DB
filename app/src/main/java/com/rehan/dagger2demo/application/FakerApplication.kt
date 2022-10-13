package com.rehan.dagger2demo.application

import android.app.Application
import com.rehan.dagger2demo.di.ApplicationComponent
import com.rehan.dagger2demo.di.DaggerApplicationComponent

class FakerApplication : Application() {

    // Initializing the component interface
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}