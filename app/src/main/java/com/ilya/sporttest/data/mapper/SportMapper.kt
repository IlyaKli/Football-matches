package com.ilya.sporttest.data.mapper

import com.ilya.sporttest.data.network.model.*
import com.ilya.sporttest.domain.model.*
import javax.inject.Inject

class SportMapper @Inject constructor() {

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
        statusName = dto.statusName,
        league = mapLeagueDtoToEntity(dto.league),
        teams = mapTeamsListDtoToEntity(dto.teams),
        scores = mapScoreDtoToEntity(dto.scores),
        time = mapTimeDtoToEntity(dto.time),
        week = dto.week,
        groupName = dto.groupName,
        weather = dto.weather?.let { mapWeatherDtoToEntity(it) }
    )

    private fun mapLeagueDtoToEntity(dto: LeagueDto) = League(
        name = dto.name,
        countryName = dto.countryName,
        countryFlagImageUrl = dto.countryFlagImageUrl
    )

    private fun mapTimeDtoToEntity(dto: TimeDto) = Time(
        time = dto.time,
        timezone = dto.timezone
    )

    private fun mapWeatherDtoToEntity(dto: WeatherDto) = Weather(
        description = dto.description,
        temperature = mapTemperatureDtoToEntity(dto.temperature)
    )

    private fun mapTemperatureDtoToEntity(dto: TemperatureDto) = Temperature(
        celsius = dto.celsius,
        fahrenheit = dto.fahrenheit
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