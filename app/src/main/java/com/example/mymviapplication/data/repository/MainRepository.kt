package com.example.mymviapplication.data.repository

import com.example.mymviapplication.data.api.RetrofitBuilder
import javax.inject.Inject

class MainRepository @Inject constructor() {
/*
    suspend fun getUsers(page:Int,limit: Int) = RetrofitBuilder.apiService.getUsers(page,limit)
*/
    suspend fun getCats() = RetrofitBuilder.apiCatService.getCats()
    fun getUserPagination() = RetrofitBuilder.getPagingAllPost()
}