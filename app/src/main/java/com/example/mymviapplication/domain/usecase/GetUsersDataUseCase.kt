package com.example.mymviapplication.domain.usecase

import com.example.mymviapplication.data.MainRepository
import javax.inject.Inject

class GetUsersDataUseCase @Inject constructor(private val mainRepository: MainRepository) {
    /*suspend fun getUsersList(page:Int,limit:Int): List<User> {
        return mainRepository.getUsers(page,limit)
    }*/
    fun invokePaging() = mainRepository.getUserPagination()
}