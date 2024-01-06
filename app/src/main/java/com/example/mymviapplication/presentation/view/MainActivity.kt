package com.example.mymviapplication.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymviapplication.presentation.compose.catsScreen.CatsScreen
import com.example.mymviapplication.presentation.compose.composeNavigation.Routes
import com.example.mymviapplication.presentation.compose.mainScreen.HomeScreen
import com.example.mymviapplication.presentation.compose.userScreen.UsersScreen
import com.example.mymviapplication.presentation.viewmodel.MainViewModel
import com.example.mymviapplication.ui.theme.MyMVIApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMVIApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.Home.routes) {
                        composable(Routes.Home.routes) {
                            HomeScreen(navController = navController)
                        }
                        composable(Routes.ListUser.routes) {
                            UsersScreen(mainViewModel = mainViewModel)
                        }
                        composable(Routes.FactCats.routes) {
                            CatsScreen(mainViewModel = mainViewModel)
                        }
                    }
                }
            }
        }
    }
}
