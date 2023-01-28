package com.ilya.sporttest.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ilya.sporttest.navigation.AppNavGraph
import com.ilya.sporttest.navigation.rememberNavigationState
import com.ilya.sporttest.presentation.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onFloatingActionButtonClickListener: () -> Unit,
) {
    val navigationState = rememberNavigationState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onFloatingActionButtonClickListener() }) {
                Icon(Icons.Filled.Search, contentDescription = null)
            }
        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRout = navBackStackEntry?.destination?.route

                val items = listOf(
                    NavigationItem.Yesterday,
                    NavigationItem.Today,
                    NavigationItem.Tomorrow
                )
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRout == item.screen.route,
                        onClick = { navigationState.navigateTo(item.screen.route) },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    ) { paddingValues ->

        AppNavGraph(
            navHostController = navigationState.navHostController,
            splashScreenContent = {},
            todayScreenContent = { MatchListScreen(viewModel = viewModel, day = "today") },
            yesterdayScreenContent = { MatchListScreen(viewModel = viewModel, day = "yesterday") },
            tomorrowScreenContent = { MatchListScreen(viewModel = viewModel, day = "tomorrow") },
            matchInfoScreenContent = {},
            webScreenContent = {}
        )

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
}