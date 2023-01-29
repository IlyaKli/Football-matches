package com.ilya.sporttest.data.repository

import com.ilya.sporttest.data.mapper.SportMapper
import com.ilya.sporttest.data.network.ApiService
import com.ilya.sporttest.domain.model.MatchesResponse
import com.ilya.sporttest.domain.repository.SportAppRepository
import javax.inject.Inject

class SportAppRepositoryImpl @Inject constructor(
//    private val sportAppDao: SportAppDao,
    private val apiService: ApiService,
    private val mapper: SportMapper
) : SportAppRepository {

    override suspend fun loadMatchesList(day: String): MatchesResponse {
        return mapper.mapMatchesResponseDtoToEntity(apiService.matchLoad(day))
    }
}