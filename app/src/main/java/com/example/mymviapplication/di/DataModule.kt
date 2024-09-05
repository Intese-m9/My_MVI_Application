package com.example.mymviapplication.di

import com.example.mymviapplication.data.repository.MainRepositoryImpl
import com.example.mymviapplication.domain.MainRepository
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
    fun provideRepository(): MainRepository {
        return MainRepositoryImpl()
    }
}