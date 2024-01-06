package com.example.mymviapplication.data.repository

import com.example.mymviapplication.data.api.RetrofitBuilder
import javax.inject.Inject

class MainRepository @Inject constructor() {
    suspend fun getUsers() = RetrofitBuilder.apiService.getUsers()
    suspend fun getCats() = RetrofitBuilder.apiCatService.getCats()
}