package com.example.mymviapplication.presentation.interactors

sealed class MainIntent {
    object UserListLoad: MainIntent()
    object CatsFactListLoaded: MainIntent()
}
