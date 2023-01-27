package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class MatchesResponseDto(
    @SerializedName("data")
    val matches: List<MatchDto>
)