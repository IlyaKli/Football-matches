package com.ilya.sporttest.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ilya.sporttest.domain.model.Match
import com.ilya.sporttest.presentation.MatchesViewModel

@Composable
fun MatchListScreen(
    day: String,
    onMatchClickListener: (Match) -> Unit
) {
    val viewModel: MatchesViewModel = viewModel()
    viewModel.loadMatches(day)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        val matches = viewModel.matches.observeAsState(listOf())
        LazyColumn {
            items(matches.value) { match ->
                MatchCard(
                    match = match,
                    onMatchCardClickListener = {
                        onMatchClickListener(match)
                    }
                )
            }
        }
    }
}