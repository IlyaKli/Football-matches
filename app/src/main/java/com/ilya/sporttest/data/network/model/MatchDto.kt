package com.ilya.sporttest.data.network.model

class MatchDto (
    val id: String,
    val status: Int,
    val league: LeagueDto,
    val teams: TeamsListDto,
    val scores: ScoreDto
)