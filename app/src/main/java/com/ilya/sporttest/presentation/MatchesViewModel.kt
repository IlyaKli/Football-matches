package com.ilya.sporttest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.sporttest.ApplicationLoginState
import com.ilya.sporttest.data.repository.SportAppRepositoryImpl
import com.ilya.sporttest.domain.model.Match
import com.ilya.sporttest.domain.usecase.LoadMatchesListUseCase
import com.ilya.sporttest.ui.theme.MatchesScreenState
import kotlinx.coroutines.launch

class MatchesViewModel() : ViewModel() {



    val repository = SportAppRepositoryImpl()

    val loadMatchesListUseCase = LoadMatchesListUseCase(repository)

    private val _loginState = MutableLiveData<ApplicationLoginState>(ApplicationLoginState.Initial)
    val loginState: LiveData<ApplicationLoginState> = _loginState

//    private val initialState = MatchesScreenState.Matches(_matches.value)

    private val _screenState = MutableLiveData<MatchesScreenState>()
    val screenState: LiveData<MatchesScreenState> = _screenState

//    private var savedState: MatchesScreenState? = initialState

    private val _matches = MutableLiveData<List<Match>>()
    val matches: LiveData<List<Match>> = _matches

//    fun showMatchInfoScreen(match: Match) {
//        savedState = _screenState.value
////        _screenState.value = MatchesScreenState.MatchInfo(match)
//    }
//
//    fun closeMatchInfoScreen() {
//        _screenState.value = savedState
//    }

    fun loadMatches(day: String) {
        try {
            viewModelScope.launch {
                _matches.value = loadMatchesListUseCase(day).matches
            }
        } catch (e: Exception) {
            Log.d("ExceptionInLoadMatches", e.message.toString())
        }
    }

    fun initialLoadMatches() {
        try {
            viewModelScope.launch {
                _matches.value = loadMatchesListUseCase("today").matches
                _loginState.value = ApplicationLoginState.Login
            }
        } catch (e: Exception) {
            Log.d("ExceptionInLoadMatches", e.message.toString())
        }
    }
}