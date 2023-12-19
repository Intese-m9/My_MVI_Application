package com.example.mymviapplication.data.repository

import com.example.mymviapplication.data.api.ApiHelper
import com.example.mymviapplication.data.api.RetrofitBuilder
import javax.inject.Inject
//private val apiHelper: ApiHelper
class MainRepository@Inject constructor() {
    suspend fun getUsers() = RetrofitBuilder.apiService.getUsers()
    //suspend fun getUser() = apiHelper
}