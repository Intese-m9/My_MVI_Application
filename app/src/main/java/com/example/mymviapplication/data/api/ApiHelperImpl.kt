package com.example.mymviapplication.data.api

import com.example.mymviapplication.data.model.User

class ApiHelperImpl(private val apiService: ApiService): ApiHelper {
    override suspend fun getUser(): List<User> {
        return apiService.getUsers()
    }
}