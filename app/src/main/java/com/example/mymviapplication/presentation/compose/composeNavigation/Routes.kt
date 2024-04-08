package com.example.mymviapplication.presentation.compose.composeNavigation

sealed class Routes(val routes: String){
    object Home: Routes("HomeScreen")
    object ListUser: Routes("listUser")
    object FactCats: Routes("listCats")
    object LoginScreen: Routes("loginScreen")
}