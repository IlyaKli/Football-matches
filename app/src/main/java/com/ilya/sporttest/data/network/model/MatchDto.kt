package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class MatchDto (

    @SerializedName("id")
    val id: Int,

    @SerializedName("status_name")
    val statusName: String,

    @SerializedName("status")
    val status: Int,

    @SerializedName("league")
    val league: LeagueDto,

    @SerializedName("teams")
    val teams: TeamsListDto,

    @SerializedName("scores")
    val scores: ScoreDto,

    @SerializedName("group_name")
    val groupName: String,

    @SerializedName("week")
    val week: String,

    @SerializedName("time")
    val time: TimeDto,

    @SerializedName("weather_report")
    val weather: WeatherDto?
)