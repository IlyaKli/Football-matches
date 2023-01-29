package com.ilya.sporttest.data.network.model

import com.google.gson.annotations.SerializedName

class WeatherDto(

    @SerializedName("desc")
    val description: String,

    @SerializedName("temp")
    val temperature: TemperatureDto
)