package com.example.triviaquest.di

import androidx.room.Room
import com.example.triviaquest.data.network.local.preferences.SettingPreferences
import com.example.triviaquest.data.network.local.preferences.dataStore
import com.example.triviaquest.data.network.local.room.QuizDatabase
import com.example.triviaquest.data.network.remote.retrofit.ApiConfig
import com.example.triviaquest.repository.AuthRepository
import com.example.triviaquest.repository.QuizRepository
import com.example.triviaquest.ui.MainViewModel
import com.example.triviaquest.ui.screen.authentication.AuthViewModel
import com.example.triviaquest.ui.screen.history.HistoryViewModel
import com.example.triviaquest.ui.screen.home.HomeViewModel
import com.example.triviaquest.ui.screen.profile.ProfileViewModel
import com.example.triviaquest.ui.screen.quiz.QuizViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        val settingPreferences = SettingPreferences(androidContext().dataStore)
        settingPreferences
    }
    single {
        Room.databaseBuilder(
            androidContext(),
            QuizDatabase::class.java, "quiz.db"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
    single { get<QuizDatabase>().QuizDao() }
    single { get<QuizDatabase>().UserDao() }
}

val networkModule = module {
    single {
        val apiService = ApiConfig.getApiService()
        apiService
    }
}

val repositoryModule = module {
    single { AuthRepository(get(),get()) }
    single { QuizRepository(get(),get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { QuizViewModel(get()) }
    viewModel { HistoryViewModel(get()) }
    viewModel { HomeViewModel(get(),get()) }
    viewModel { AuthViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
}
