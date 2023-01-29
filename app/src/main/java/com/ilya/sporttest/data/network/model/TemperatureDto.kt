package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class TemperatureDto(

    @SerializedName("celsius")
    val celsius: String,

    @SerializedName("fahrenheit")
    val fahrenheit: String
)