package com.example.mymviapplication.data.api

import com.example.mymviapplication.data.model.modelCat.Cats
import com.example.mymviapplication.data.model.modelUser.User
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") pageNumber: Int,
        @Query("limit") limit: Int,
    ): List<User>

    @GET("facts")
    suspend fun getCats(): Cats
}
