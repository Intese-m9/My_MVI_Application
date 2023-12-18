package com.example.mymviapplication.data.repository

import com.example.mymviapplication.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUser()
}