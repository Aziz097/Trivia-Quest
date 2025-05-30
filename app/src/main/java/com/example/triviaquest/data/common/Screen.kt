package com.example.triviaquest.data.common

sealed class Screen(val route: String) {
    // root screen
    data object Main : Screen("Main")
    data object OnBoarding : Screen("OnBoarding")
    data object Welcome : Screen("Welcome")
    data object Login : Screen("Login")
    data object Register : Screen("Register")

    // main screen
    data object Home : Screen("Home")
    data object Category : Screen("Category")
    data object Profile : Screen("Profile")
    data object History : Screen("History")
    data object List : Screen("List")
    data object SelectQuiz : Screen("SelectQuiz")

    //quiz screen
    data object QuizStart : Screen("QuizStart")
    data object QuizQuestion : Screen("QuizQuestion")
    data object QuizResult : Screen("QuizResult")
    data object QuizMode : Screen("QuizDetail")
    data object QuizOption : Screen("QuizOption")
    data object QuizAnswerResult : Screen("QuizAnswerResult")
}


