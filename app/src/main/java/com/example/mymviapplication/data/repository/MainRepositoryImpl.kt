package com.example.mymviapplication.data.repository

import com.example.mymviapplication.data.api.RetrofitBuilder
import com.example.mymviapplication.data.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(): MainRepository {
/*
    suspend fun getUsers(page:Int,limit: Int) = RetrofitBuilder.apiService.getUsers(page,limit)
*/
     override suspend fun getCats() = RetrofitBuilder.apiCatService.getCats()
     override fun getUserPagination() = RetrofitBuilder.getPagingAllPost()
}