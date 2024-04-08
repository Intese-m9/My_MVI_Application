package com.example.mymviapplication.presentation.compose.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mymviapplication.presentation.compose.components.CustominpitField
import com.example.mymviapplication.presentation.compose.composeNavigation.Routes
import com.example.mymviapplication.presentation.interactors.LoginIntent
import com.example.mymviapplication.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val loginFormState = loginViewModel.state.value
        CustominpitField(
            value = loginFormState.email.text,
            placeholder = "Email",
            onFocusChange = {
                loginViewModel.createEvent(
                    LoginIntent.FocusChange("email")
                )
            },
            onValueChange = { value ->
                loginViewModel.createEvent(
                    LoginIntent.EnteredEmail(value)
                )
            },
            hasError = !loginFormState.email.isValid,
            errorMessage = loginFormState.email.errorMessage,
            textColor = Color.Black
        )
        CustominpitField(
            value = loginFormState.password.text,
            placeholder = "Password",
            onFocusChange = {
                loginViewModel.createEvent(
                    LoginIntent.FocusChange("password")
                )
            },
            onValueChange = { value ->
                loginViewModel.createEvent(
                    LoginIntent.EnteredPassword(value)
                )
            },
            hasError = !loginFormState.password.isValid,
            errorMessage = loginFormState.password.errorMessage,
            textColor = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                navController.navigate(Routes.Home.routes)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                disabledContentColor = Color.Gray
            ),
            enabled = loginFormState.formValid
        ) {
            Text(
                text = "Login"
            )
        }
    }
}