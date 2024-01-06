package com.example.mymviapplication.presentation.compose.catsScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.mymviapplication.presentation.compose.stateScreen.ErrorScreen
import com.example.mymviapplication.presentation.compose.stateScreen.LoadingScreen
import com.example.mymviapplication.presentation.interactors.MainIntent
import com.example.mymviapplication.presentation.state.CatState
import com.example.mymviapplication.presentation.viewmodel.MainViewModel

@Composable
fun CatsScreen(mainViewModel: MainViewModel) {
    val state by mainViewModel.catState
    when (state) {
        is CatState.Loading -> LoadingScreen()
        is CatState.Success -> {
            val listCats = (state as CatState.Success).cats
            CatsAndOther(listCats)
        }

        is CatState.Error -> ErrorScreen()
    }

    LaunchedEffect(Unit) {
        mainViewModel.getListIntent(MainIntent.UserListLoad)
        mainViewModel.getListIntent(MainIntent.CatsFactListLoaded)
    }
}