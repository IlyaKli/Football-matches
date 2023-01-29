package com.ilya.sporttest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.sporttest.data.repository.SportAppRepositoryImpl
import com.ilya.sporttest.domain.model.Match
import com.ilya.sporttest.domain.usecase.LoadMatchesListUseCase
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {


    val repository = SportAppRepositoryImpl()

    val loadMatchesListUseCase = LoadMatchesListUseCase(repository)

    private val _matches = MutableLiveData<List<Match>>()
    val matches: LiveData<List<Match>> = _matches

    fun loadMatches(day: String) {
        viewModelScope.launch {
            _matches.value = loadMatchesListUseCase(day).matches
        }
    }
}