package com.ilya.sporttest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    splashScreenContent: @Composable () -> Unit,
    todayScreenContent: @Composable () -> Unit,
    yesterdayScreenContent: @Composable () -> Unit,
    tomorrowScreenContent: @Composable () -> Unit,
    matchInfoScreenContent: @Composable () -> Unit,
    webScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            splashScreenContent()
        }
        composable(Screen.MatchListToday.route) {
            todayScreenContent()
        }
        composable(Screen.MatchListYesterday.route) {
            yesterdayScreenContent()
        }
        composable(Screen.MatchListTomorrow.route) {
            tomorrowScreenContent()
        }
        composable(Screen.MatchInfo.route) {
            matchInfoScreenContent()
        }
        composable(Screen.Web.route) {
            webScreenContent()
        }
    }
}