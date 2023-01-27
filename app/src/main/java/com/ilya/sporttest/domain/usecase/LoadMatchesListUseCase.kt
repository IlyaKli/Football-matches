package com.ilya.sporttest.domain.usecase

import com.ilya.sporttest.domain.repository.SportAppRepository

class LoadMatchesListUseCase(val repository: SportAppRepository) {
    suspend operator fun invoke(day: String) = repository.loadMatchesList(day)
}