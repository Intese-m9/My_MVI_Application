package com.example.mymviapplication.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mymviapplication.data.api.ApiService
import com.example.mymviapplication.data.model.modelUser.User

class PagingSource(private val apiService: ApiService) : PagingSource<Int, User>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val page = params.key ?: 1
            val limit = 5
            val userResponse = apiService.getUsers(page, limit)
            LoadResult.Page(
                data = userResponse,
                prevKey = if (page > 1) page - 1 else null,
                nextKey = page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}