package com.example.mymviapplication.presentation.interactors

sealed class LoginIntent {
    data class EnteredEmail(val value: String) : LoginIntent()
    data class EnteredPassword(val value: String) : LoginIntent()
    data class FocusChange(val focusChange: String) : LoginIntent()
}