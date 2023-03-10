package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class LeagueDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("country_name")
    val countryName: String,

    @SerializedName("country_flag")
    val countryFlagImageUrl: String
)