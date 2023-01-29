package com.ilya.sporttest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.gson.Gson
import com.ilya.sporttest.domain.model.Match

fun NavGraphBuilder.yesterdayScreenNavGraph(
    yesterdayScreenContent: @Composable () -> Unit,
    matchInfoScreenContent: @Composable (Match) -> Unit
) {
    navigation(
        startDestination = Screen.MatchListYesterday.route,
        route = Screen.Yesterday.route
    ) {
        composable(Screen.MatchListYesterday.route) {
            yesterdayScreenContent()
        }
        composable(
            route = Screen.MatchInfo.route,
            arguments = listOf(
                navArgument(Screen.KEY_MATCH) {
                    type = NavType.StringType
                }
            )
        ) {
            val matchJson = it.arguments?.getString(Screen.KEY_MATCH) ?: ""
            val match = Gson().fromJson(matchJson, Match::class.java)
            matchInfoScreenContent(match)
        }
    }
}