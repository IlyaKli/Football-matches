package com.ilya.sporttest.presentation.matchinfo

import com.ilya.sporttest.domain.model.Match

sealed class MatchInfoScreenState {

    object Initial: MatchInfoScreenState()

    data class MatchInfo(val match: Match): MatchInfoScreenState()
}
