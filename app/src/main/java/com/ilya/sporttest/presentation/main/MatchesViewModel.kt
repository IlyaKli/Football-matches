package com.ilya.sporttest.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilya.sporttest.domain.usecase.LoadMatchesListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MatchesViewModel @Inject constructor(
    private val loadMatchesListUseCase: LoadMatchesListUseCase,
) : ViewModel() {

    private val _mainScreenState =
        MutableLiveData<ApplicationLoginState>(ApplicationLoginState.Initial)
    val mainScreenState: LiveData<ApplicationLoginState> = _mainScreenState

    private val _screenState = MutableLiveData<MatchesScreenState>(MatchesScreenState.Initial)
    val screenState: LiveData<MatchesScreenState> = _screenState

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun loadMatches(day: String) {
        _screenState.value = MatchesScreenState.Loading
        viewModelScope.launch {
            try {
                _screenState.value = MatchesScreenState.Matches(loadMatchesListUseCase(day).matches)
            } catch (exception: Exception) {
                Log.d("Exception in load", exception.message.toString())
                if (exception.message == INTERNET_ERROR_MESSAGE) {
                    _error.value = INTERNET_ERROR_MESSAGE_TOAST
                } else {
                    _error.value = exception.message.toString()
                }
            } finally {
                _mainScreenState.value = ApplicationLoginState.Login
            }
        }
    }


    fun initialLoadMatches() {
        viewModelScope.launch {
            try {
                _screenState.value =
                    MatchesScreenState.Matches(loadMatchesListUseCase(INITIAL_INFO_DAY).matches)
                _mainScreenState.value = ApplicationLoginState.Login
            } catch (exception: Exception) {
                Log.d("Exception in load", exception.message.toString())
                if (exception.message == INTERNET_ERROR_MESSAGE) {
                    _error.value = INTERNET_ERROR_MESSAGE_TOAST
                } else {
                    _error.value = exception.message.toString()
                }
            }
        }
    }

    fun openWebScreen() {
        _mainScreenState.value = ApplicationLoginState.Web
    }

    private companion object {
        const val INTERNET_ERROR_MESSAGE = """Unable to resolve host "api.soccersapi.com": No address associated with hostname"""

        const val INTERNET_ERROR_MESSAGE_TOAST = "Отсутствует интернет соединение"

        const val INITIAL_INFO_DAY = "today"
    }
}