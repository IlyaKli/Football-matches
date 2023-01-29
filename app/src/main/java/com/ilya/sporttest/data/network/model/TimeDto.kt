package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class TimeDto(

    @SerializedName("time")
    val time: String,

    @SerializedName("timezone")
    val timezone: String
)