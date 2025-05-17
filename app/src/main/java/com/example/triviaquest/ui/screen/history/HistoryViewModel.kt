package com.example.triviaquest.ui.screen.history

import androidx.lifecycle.ViewModel
import com.example.triviaquest.data.network.local.room.HistoryEntity
import com.example.triviaquest.repository.QuizRepository
import kotlinx.coroutines.flow.Flow


class HistoryViewModel(
    private val repository: QuizRepository
): ViewModel(){

    fun getHistory(): Flow<List<HistoryEntity>> {
        return repository.getHistory()
    }

}