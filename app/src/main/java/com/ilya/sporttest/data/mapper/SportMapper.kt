package com.ilya.sporttest.data.mapper

import com.ilya.sporttest.data.network.model.*
import com.ilya.sporttest.domain.model.*

class SportMapper {

    fun mapMatchesResponseDtoToEntity(dto: MatchesResponseDto) = MatchesResponse(
        matches = mapMatchDtoListToEntityList(dto.matches)
    )

    private fun mapMatchDtoListToEntityList(list: List<MatchDto>): List<Match> {
        return list.map {
            mapMatchDtoToEntity(it)
        }
    }

    private fun mapMatchDtoToEntity(dto: MatchDto) = Match(
        id = dto.id,
        status = dto.status,
        league = mapLeagueDtoToEntity(dto.league),
        teams = mapTeamsListDtoToEntity(dto.teams),
        scores = mapScoreDtoToEntity(dto.scores)
    )

    private fun mapLeagueDtoToEntity(dto: LeagueDto) = League(
        name = dto.name
    )

    private fun mapTeamsListDtoToEntity(dto: TeamsListDto) = TeamsList(
        home = mapTeamDtoToEntity(dto.home),
        away = mapTeamDtoToEntity(dto.away)
    )

    private fun mapTeamDtoToEntity(dto: TeamDto) = Team(
        id = dto.id,
        name = dto.name,
        image = dto.image
    )

    private fun mapScoreDtoToEntity(dto: ScoreDto) = Score(
        homeScore = dto.homeScore,
        awayScore = dto.awayScore
    )
}