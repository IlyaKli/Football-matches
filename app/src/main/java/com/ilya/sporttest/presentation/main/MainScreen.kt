package com.ilya.sporttest.presentation.main

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ilya.sporttest.navigation.AppNavGraph
import com.ilya.sporttest.navigation.rememberNavigationState
import com.ilya.sporttest.presentation.matchinfo.MatchInfoScreen

@Composable
fun MainScreen() {

    val navigationState = rememberNavigationState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {  }) {
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
            todayScreenContent = { MatchListScreen(day = "today") {
                navigationState.navigateToMatchInfo(it)
            } },
            yesterdayScreenContent = { MatchListScreen(day = "yesterday") {
                navigationState.navigateToMatchInfo(it)
            } },
            tomorrowScreenContent = { MatchListScreen(day = "tomorrow") {
                navigationState.navigateToMatchInfo(it)
            } },
            matchInfoScreenContent = { match ->
                MatchInfoScreen(match) {
                    navigationState.navHostController.popBackStack()
                }
            }
        )
    }
}