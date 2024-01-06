package com.example.mymviapplication.presentation.compose.userScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.mymviapplication.presentation.compose.stateScreen.ErrorScreen
import com.example.mymviapplication.presentation.compose.stateScreen.LoadingScreen
import com.example.mymviapplication.presentation.interactors.MainIntent
import com.example.mymviapplication.presentation.state.MainState
import com.example.mymviapplication.presentation.viewmodel.MainViewModel

@Composable
fun UsersScreen(mainViewModel: MainViewModel) {
    val state by mainViewModel.state
    when (state) {
        is MainState.Loading -> LoadingScreen()
        is MainState.Success -> {
            val listUser = (state as MainState.Success).user
            UsersList(listUser)
        }

        is MainState.Error -> ErrorScreen()
    }

    LaunchedEffect(Unit) {
        mainViewModel.getListIntent(MainIntent.UserListLoad)
    }
}