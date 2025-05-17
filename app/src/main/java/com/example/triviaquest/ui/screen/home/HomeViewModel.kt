package com.example.triviaquest.ui.screen.home

import androidx.lifecycle.ViewModel
import com.example.triviaquest.data.network.local.room.HistoryEntity
import com.example.triviaquest.data.network.local.room.UserEntity
import com.example.triviaquest.repository.AuthRepository
import com.example.triviaquest.repository.QuizRepository
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    private val quizRepository: QuizRepository,
    private val authRepository: AuthRepository,
) : ViewModel() {

    fun getLatestHistory(): Flow<HistoryEntity> {
        return quizRepository.getLatestHistory()
    }

    fun getUser(email:String): Flow<UserEntity> {
        return authRepository.getUser(email)
    }
}