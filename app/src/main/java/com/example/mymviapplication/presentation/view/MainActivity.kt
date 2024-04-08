package com.example.mymviapplication.presentation.view

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mymviapplication.domain.permissions.RuntimePermissionDialog
import com.example.mymviapplication.domain.usecase.StartWorkManagerUseCase
import com.example.mymviapplication.presentation.compose.auth.LoginScreen
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
    private val startWorkManager by lazy { StartWorkManagerUseCase() }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startWorkManager.startWorker(applicationContext)
        setContent {
            MyMVIApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    RuntimePermissionDialog(
                        android.Manifest.permission.POST_NOTIFICATIONS,
                        onPermissionDenied = {},
                        onPermissionGranted = {},
                    )
                    NavHost(navController = navController, startDestination = Routes.LoginScreen.routes) {
                        composable(Routes.LoginScreen.routes){
                            LoginScreen(navController = navController)
                        }
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
