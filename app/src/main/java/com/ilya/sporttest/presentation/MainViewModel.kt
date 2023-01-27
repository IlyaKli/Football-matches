package com.ilya.sporttest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilya.sporttest.domain.model.Match

class MainViewModel() : ViewModel() {


    private val _matches = MutableLiveData<List<Match>>()
    val matches: LiveData<List<Match>> = _matches

    fun loadMatches() {

    }
}