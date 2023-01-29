package com.ilya.sporttest.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.sporttest.data.repository.SportAppRepositoryImpl
import com.ilya.sporttest.domain.model.Match
import com.ilya.sporttest.domain.usecase.LoadMatchesListUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MatchesViewModel() : ViewModel() {



    val repository = SportAppRepositoryImpl()

    val loadMatchesListUseCase = LoadMatchesListUseCase(repository)

    private val _mainScreenState = MutableLiveData<ApplicationLoginState>(ApplicationLoginState.Initial)
    val mainScreenState: LiveData<ApplicationLoginState> = _mainScreenState

    private val _screenState = MutableLiveData<MatchesScreenState>(MatchesScreenState.Initial)
    val screenState: LiveData<MatchesScreenState> = _screenState

    private val _matches = MutableLiveData<List<Match>>()
    val matches: LiveData<List<Match>> = _matches

    fun loadMatches(day: String) {
        _screenState.value = MatchesScreenState.Loading
        try {
            viewModelScope.launch {
                _screenState.value = MatchesScreenState.Matches(loadMatchesListUseCase(day).matches)
            }
        } catch (e: Exception) {
            Log.d("ExceptionInLoadMatches", e.message.toString())
        } finally {

        }
    }

    fun initialLoadMatches() {
        try {
            viewModelScope.launch {
                _screenState.value = MatchesScreenState.Matches(loadMatchesListUseCase("today").matches)
                _mainScreenState.value = ApplicationLoginState.Login
            }
        } catch (e: Exception) {
            Log.d("ExceptionInLoadMatches", e.message.toString())
        } finally {

        }
    }

    fun openWebScreen() {
        _mainScreenState.value = ApplicationLoginState.Web
    }
}