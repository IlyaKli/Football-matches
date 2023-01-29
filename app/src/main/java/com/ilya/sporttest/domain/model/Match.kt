package com.ilya.sporttest.domain.model


data class Match(
    val id: Int,
    val status: Int,
    val statusName: String,
    val league: League,
    val teams: TeamsList,
    val scores: Score,
    val groupName: String,
    val week: String,
    val time: Time,
    val weather: Weather?
)
