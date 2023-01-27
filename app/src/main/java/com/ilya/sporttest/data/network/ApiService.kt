package com.ilya.sporttest.data.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("livescores/?user=ilya.klimkin.0253&token=cd7d47c849370fb2cebbbb11bfbe0437&t=tomorrow")
    suspend fun matchLoad(@Query("t") day: String) : Single<MovieResponseDto>

//    @GET("movie?token=RTPA40T-C5CMF17-N98WW8N-S4QQ97W&field=id")
//    fun trailerLoad(@Query("search") id: Int) : Single<TrailerResponseDto>
//
//    @GET("review?token=RTPA40T-C5CMF17-N98WW8N-S4QQ97W&field=movieId")
//    fun reviewLoad(@Query("search") movieId: Int) : Single<ReviewResponseDto>
}