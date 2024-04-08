package com.example.mymviapplication.presentation.state


enum class InputType{
    TEXT,
    MAIL,
    PASSWORD,
    NUMBER,
}
data class InputState (
    val text: String = "",
    val isValid: Boolean = true,
    val type: InputType,
    val errorMessage: String = ""
)