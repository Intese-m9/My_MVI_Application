package com.example.mymviapplication.di

import com.example.mymviapplication.data.repository.MainRepositoryImpl
import com.example.mymviapplication.domain.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
  abstract fun provideRepository(impl:MainRepositoryImpl): MainRepository
  }