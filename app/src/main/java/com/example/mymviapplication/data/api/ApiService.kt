package com.example.mymviapplication.data.api

import com.example.mymviapplication.data.model.modelCat.Cats
import com.example.mymviapplication.data.model.modelUser.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("facts")
    suspend fun getCats(): Cats
}
