package com.ilya.sporttest.data.network

import com.ilya.sporttest.data.network.model.MatchesResponseDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET("livescores/?user=ilya.klimkin.0253&token=cd7d47c849370fb2cebbbb11bfbe0437")
    suspend fun matchLoad( @Query("t") day: String) : MatchesResponseDto
}