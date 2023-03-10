package com.ilya.sporttest.presentation.main

import com.ilya.sporttest.domain.model.Match

sealed class MatchesScreenState {

    object Initial: MatchesScreenState()

    object Loading: MatchesScreenState()

    data class Matches(val matches: List<Match>): MatchesScreenState()


}