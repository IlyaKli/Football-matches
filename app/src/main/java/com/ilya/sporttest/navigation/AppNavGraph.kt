package com.ilya.sporttest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ilya.sporttest.domain.model.Match

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    todayScreenContent: @Composable () -> Unit,
    yesterdayScreenContent: @Composable () -> Unit,
    tomorrowScreenContent: @Composable () -> Unit,
    matchInfoScreenContent: @Composable (Match) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Today.route
    ) {
        todayScreenNavGraph(
            todayScreenContent = todayScreenContent,
            matchInfoScreenContent = matchInfoScreenContent
        )
        yesterdayScreenNavGraph(
            yesterdayScreenContent = yesterdayScreenContent,
            matchInfoScreenContent = matchInfoScreenContent
        )
        tomorrowScreenNavGraph(
            tomorrowScreenContent = tomorrowScreenContent,
            matchInfoScreenContent = matchInfoScreenContent
        )
    }
}