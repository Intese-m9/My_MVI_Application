package com.example.mymviapplication.data.api

import com.example.mymviapplication.data.model.User
import retrofit2.http.GET

interface ApiService{
    @GET("users")
    suspend fun getUsers(): List<User>
}