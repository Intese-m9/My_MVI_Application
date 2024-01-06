package com.example.mymviapplication.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymviapplication.domain.usecase.GetCatsDataUseCase
import com.example.mymviapplication.domain.usecase.GetUsersDataUseCase
import com.example.mymviapplication.presentation.interactors.MainIntent
import com.example.mymviapplication.presentation.state.CatState
import com.example.mymviapplication.presentation.state.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCatsDataUseCase: GetCatsDataUseCase,
    private val getUsersDataUseCase: GetUsersDataUseCase
) : ViewModel() {
    private val _stateUsers = mutableStateOf<MainState>(MainState.Loading)
    val state: State<MainState> = _stateUsers

    private val _stateCats = mutableStateOf<CatState>(CatState.Loading)
    val catState: State<CatState> = _stateCats


    fun getListIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.UserListLoad -> getUserList()
            is MainIntent.CatsFactListLoaded -> getCatsFact()
        }
    }

    private fun getUserList() {
        viewModelScope.launch {
            _stateUsers.value = MainState.Loading
            try {
                _stateUsers.value = MainState.Success(
                    getUsersDataUseCase.getUsersList()
                )
            } catch (e: IOException) {
                _stateUsers.value = MainState.Error(
                    "Error"
                )
            }
        }
    }

    private fun getCatsFact() {
        viewModelScope.launch {
            _stateCats.value = CatState.Loading
            try {
                _stateCats.value = CatState.Success(
                    getCatsDataUseCase.getCatsList()
                )
            } catch (e: IOException) {
                _stateCats.value = CatState.Error("Error")
            }
        }
    }
}