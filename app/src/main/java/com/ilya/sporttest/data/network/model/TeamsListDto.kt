package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class TeamsListDto(
    @SerializedName("home")
    val home: TeamDto,

    @SerializedName("away")
    val away: TeamDto
)