package com.example.mymviapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.mymviapplication.presentation.interactors.MainIntent
import com.example.mymviapplication.presentation.state.MainState
import com.example.mymviapplication.presentation.viewmodel.MainViewModel
import com.example.mymviapplication.ui.theme.MyMVIApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        render()
        setContent {
            MyMVIApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Button(onClick = {
                        lifecycleScope.launch {
                            mainViewModel.userIntent.send(MainIntent.FetchUser)
                        }
                    }) {
                        Text(text = "Get users")

                    }
                }
            }
        }
    }
    private fun render(){
        lifecycleScope.launch {
            mainViewModel.state.collect{
                when(it){
                    is MainState.Idle ->{

                    }
                    is MainState.Loading ->{
                        println("Добавить ripple эффект")
                    }
                    is MainState.Users ->{
                        println(it.user)
                    }
                    is MainState.Error ->{
                        println("error")
                    }

                }
            }
        }
    }

}
