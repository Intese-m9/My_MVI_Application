package com.example.mymviapplication.presentation.compose.mainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mymviapplication.presentation.compose.composeNavigation.Routes

@Composable
fun HomeScreen(navController: NavController) {
    Column(verticalArrangement = Arrangement.Center) {
        Button(
            onClick = { navController.navigate(Routes.ListUser.routes) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Users")
        }
        Button(
            onClick = { navController.navigate(Routes.FactCats.routes) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Cats")
        }
    }
}
