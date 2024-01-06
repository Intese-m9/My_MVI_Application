package com.example.mymviapplication.presentation.state

import com.example.mymviapplication.data.model.modelUser.User

sealed class MainState {
    data class Success(val user: List<User>) : MainState()
    data class Error(val message: String) : MainState()
    object Loading : MainState()
}