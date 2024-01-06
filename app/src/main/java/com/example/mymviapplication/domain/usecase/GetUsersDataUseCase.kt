package com.example.mymviapplication.domain.usecase

import com.example.mymviapplication.data.model.modelUser.User
import com.example.mymviapplication.data.repository.MainRepository
import javax.inject.Inject

class GetUsersDataUseCase @Inject constructor(private val mainRepository: MainRepository) {
    suspend fun getUsersList(): List<User> {
        return mainRepository.getUsers()
    }
}