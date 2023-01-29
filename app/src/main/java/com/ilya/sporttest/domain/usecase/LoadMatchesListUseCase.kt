package com.ilya.sporttest.domain.usecase

import com.ilya.sporttest.domain.repository.SportAppRepository
import javax.inject.Inject

class LoadMatchesListUseCase@Inject constructor(
    private val repository: SportAppRepository
) {
    suspend operator fun invoke(day: String) = repository.loadMatchesList(day)
}