package com.example.mymviapplication.data.api

import com.example.mymviapplication.data.model.User

interface ApiHelper {
    suspend fun getUser(): List<User>
}