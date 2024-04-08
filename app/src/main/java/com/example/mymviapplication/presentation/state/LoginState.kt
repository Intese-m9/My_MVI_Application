package com.example.mymviapplication.presentation.state

data class LoginState(
    val email: InputState = InputState(type = InputType.MAIL),
    val password: InputState = InputState(type = InputType.PASSWORD),
    val formValid: Boolean
)

