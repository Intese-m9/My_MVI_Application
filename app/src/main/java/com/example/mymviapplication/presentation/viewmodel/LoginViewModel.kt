package com.example.mymviapplication.presentation.viewmodel

import android.text.TextUtils
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mymviapplication.presentation.interactors.LoginIntent
import com.example.mymviapplication.presentation.state.InputType
import com.example.mymviapplication.presentation.state.LoginState

class LoginViewModel : ViewModel() {
    private val _state = mutableStateOf(LoginState(formValid = true))
    val state: State<LoginState> = _state

    fun createEvent(event: LoginIntent) {//публичный метод передает события в данную вьюмодель
        //абстрактная прослойка между компоуз экраном и нашей моделькой
        onEvent(event = event)
    }

    private fun onEvent(event: LoginIntent) {
        //принимает полученное состояние и выполняет дейтсвие
        when (event) {
            is LoginIntent.EnteredEmail -> {
              /*  _state.value = state.value.copy(
                    email = state.value.email.copy(
                        text = event.value
                    )
                )*/
                _state.value = state.value.copy(
                    email = state.value.email.copy(
                        text = event.value
                    )
                )
            }

            is LoginIntent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = state.value.password.copy(
                        text = event.value
                    ),
                )
            }

            is LoginIntent.FocusChange -> {
                when (event.focusChange) {

                    "email" -> {
                        val emailValid = validateInput(state.value.email.text, InputType.MAIL)
                        _state.value = state.value.copy(
                            email = state.value.email.copy(
                                isValid = emailValid,
                                errorMessage = "Email is not valid"
                            ),
                            formValid = emailValid
                        )
                    }

                    "password" -> {
                        val passwordValid =
                            validateInput(state.value.password.text, InputType.PASSWORD)
                        _state.value = state.value.copy(
                            password = state.value.password.copy(
                                isValid = passwordValid,
                                errorMessage = "Password os not valid"
                            ),
                            formValid = passwordValid
                        )
                    }
                }
            }
        }
    }

    private fun validateInput(inputValue: String, inputType: InputType): Boolean {
        when (inputType) {
            InputType.MAIL -> {
                return !TextUtils.isEmpty(inputValue) && android.util.Patterns.EMAIL_ADDRESS.matcher(
                    inputValue
                ).matches()
            }

            InputType.PASSWORD -> {
                return !TextUtils.isEmpty(inputValue) && inputValue.length > 5
            }

            InputType.TEXT -> {
                // пользовательская логика проверки текстового ввода
                return true
            }

            InputType.NUMBER -> {
                // пользовательская логика проверки числового ввода
                return true
            }
        }
    }


}