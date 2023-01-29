package com.ilya.sporttest.domain.model

data class Match(
    val id: Int,
    val status: Int,
    val league: League,
    val teams: TeamsList,
    val scores: Score
)
