package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class MatchDto (

    @SerializedName("id")
    val id: Int,

    @SerializedName("status")
    val status: Int,

    @SerializedName("league")
    val league: LeagueDto,

    @SerializedName("teams")
    val teams: TeamsListDto,

    @SerializedName("scores")
    val scores: ScoreDto
)