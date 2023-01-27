package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class TeamDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("img")
    val image: String
)