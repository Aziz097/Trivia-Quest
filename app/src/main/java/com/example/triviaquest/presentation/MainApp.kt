package com.example.triviaquest.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.triviaquest.data.common.Screen
import com.example.triviaquest.ui.MainViewModel
import com.example.triviaquest.ui.screen.authentication.LoginScreen
import com.example.triviaquest.ui.screen.authentication.RegisterScreen
import com.example.triviaquest.ui.screen.authentication.WelcomeScreen
import com.example.triviaquest.ui.screen.onboarding.OnBoarding
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainApp(
    mainViewModel: MainViewModel = koinViewModel()
) {
    val navController = rememberNavController()

    mainViewModel.token.collectAsState().value.let { token ->
        NavHost(
            navController = navController,
            startDestination = if (token == null) Screen.OnBoarding.route else Screen.Main.route
        ) {
            composable(Screen.OnBoarding.route) {
                OnBoarding(navController)
            }
            composable(Screen.Welcome.route) {
                WelcomeScreen(navController)
            }
            composable(Screen.Login.route) {
                LoginScreen(navController)
            }
            composable(Screen.Register.route) {
                RegisterScreen(navController)
            }
            composable(Screen.Main.route) {
                MainScreen()
            }
        }
    }
}
