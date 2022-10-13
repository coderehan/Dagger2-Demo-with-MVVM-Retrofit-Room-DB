package com.rehan.dagger2demo.di

import android.content.Context
import androidx.room.Room
import com.rehan.dagger2demo.db.FakerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)   // This means it will create single instance of Room DB through whole application
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakerDB(@ApplicationContext context: Context) : FakerDB{
        return Room.databaseBuilder(context, FakerDB::class.java, "FakerDB").build()
    }
}