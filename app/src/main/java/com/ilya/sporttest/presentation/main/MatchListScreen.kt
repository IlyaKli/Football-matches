package com.ilya.sporttest.presentation.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ilya.sporttest.domain.model.Match

@Composable
fun MatchListScreen(
    viewModel: MatchesViewModel,
    day: String,
    onMatchClickListener: (Match) -> Unit
) {
    val screenState = viewModel.screenState.observeAsState(MatchesScreenState.Initial)
    when (val currentState = screenState.value) {
        is MatchesScreenState.Initial -> {
            viewModel.loadMatches(day)
        }
        is MatchesScreenState.Matches -> {

            MatchList(
                matches = currentState.matches
            ) {
                onMatchClickListener(it)
            }
        }
        is MatchesScreenState.Loading -> {
            LoadingInfo()
        }
    }
}

@Composable
fun MatchList(
    matches: List<Match>,
    onMatchClickListener: (Match) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        LazyColumn {
            items(matches) { match ->
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

@Composable
fun LoadingInfo() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colors.onPrimary
        )
    }
}