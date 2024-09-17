package com.example.mymviapplication.data.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.mymviapplication.data.paging.PagingSource
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"
    private const val BASE_URL_CAT = "https://catfact.ninja/"
    private val apiService: ApiService = getUserRetrofit().create(ApiService::class.java)
    val apiCatService: ApiService = getCatsRetrofit().create(ApiService::class.java)

    private fun getUserRetrofit() =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create())
            .build()

    private fun getCatsRetrofit() =
        Retrofit.Builder().baseUrl(BASE_URL_CAT).addConverterFactory(MoshiConverterFactory.create())
            .build()

    fun getPagingAllPost() = Pager(config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { PagingSource(apiService = apiService) }).flow


}

