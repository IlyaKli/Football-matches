package com.ilya.sporttest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.sporttest.data.repository.SportAppRepositoryImpl
import com.ilya.sporttest.domain.usecase.LoadMatchesListUseCase
import kotlinx.coroutines.launch

//class MainViewModel : ViewModel() {
//
//    val repository = SportAppRepositoryImpl()
//
//    val loadMatchesListUseCase = LoadMatchesListUseCase(repository)
//
//    fun loadMatches(day: String) {
//        viewModelScope.launch {
//            _matches.value = loadMatchesListUseCase(day).matches
//        }
//    }
//}