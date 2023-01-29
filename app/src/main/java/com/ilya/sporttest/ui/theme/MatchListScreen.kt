package com.ilya.sporttest.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.ilya.sporttest.presentation.MainViewModel

@Composable
fun MatchListScreen(
    viewModel: MainViewModel,
    day: String
) {
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
                        Log.d("clickCard", it.toString())
                    }
                )
            }
        }
    }
}