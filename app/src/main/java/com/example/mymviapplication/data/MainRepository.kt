package com.example.mymviapplication.data

import androidx.paging.PagingData
import com.example.mymviapplication.data.model.modelCat.Cats
import com.example.mymviapplication.data.model.modelUser.User
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getCats():Cats
    fun getUserPagination(): Flow<PagingData<User>>
}