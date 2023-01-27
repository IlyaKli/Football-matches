package com.ilya.sporttest.data.network

import com.ilya.sporttest.data.network.model.MatchesResponseDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("livescores/?user=ilya.klimkin.0253&token=cd7d47c849370fb2cebbbb11bfbe0437&t=tomorrow")
    suspend fun matchLoad(@Query("t") day: String) : MatchesResponseDto
}