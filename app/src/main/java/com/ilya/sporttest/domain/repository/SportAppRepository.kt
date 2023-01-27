package com.ilya.sporttest.domain.repository

import com.ilya.sporttest.domain.model.MatchesResponse

interface SportAppRepository {
    suspend fun loadMatchesList(day: String) : MatchesResponse
}