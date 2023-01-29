package com.ilya.sporttest.data.repository

import com.ilya.sporttest.data.mapper.SportMapper
import com.ilya.sporttest.data.network.ApiFactory
import com.ilya.sporttest.domain.model.MatchesResponse
import com.ilya.sporttest.domain.repository.SportAppRepository

class SportAppRepositoryImpl : SportAppRepository {

    private val apiService = ApiFactory.apiService
    private val mapper = SportMapper()

    override suspend fun loadMatchesList(day: String): MatchesResponse {
        return mapper.mapMatchesResponseDtoToEntity(apiService.matchLoad(day))
    }
}