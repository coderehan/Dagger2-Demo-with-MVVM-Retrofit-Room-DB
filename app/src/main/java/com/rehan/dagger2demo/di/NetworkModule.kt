package com.rehan.dagger2demo.di

import com.rehan.dagger2demo.retrofit.FakerAPI
import com.rehan.dagger2demo.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFakerAPI(retrofit: Retrofit): FakerAPI {
        return retrofit.create(FakerAPI::class.java)        // Here Retrofit will look for this interface FakerAPI class which has some methods inside it and retrofit will provide body of those methods
    }
}