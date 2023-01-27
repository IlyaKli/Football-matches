package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class ScoreDto(
    @SerializedName("home_score")
    val homeScore: Int,

    @SerializedName("away_score")
    val awayScore: Int
)