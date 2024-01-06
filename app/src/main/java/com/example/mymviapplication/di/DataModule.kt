package com.example.mymviapplication.di

import com.example.mymviapplication.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun prodvideRepository(): MainRepository {
        return MainRepository()
    }
}