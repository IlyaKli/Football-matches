package com.ilya.sporttest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.gson.Gson
import com.ilya.sporttest.domain.model.Match

fun NavGraphBuilder.tomorrowScreenNavGraph(
    tomorrowScreenContent: @Composable () -> Unit,
    matchInfoScreenContent: @Composable (Match) -> Unit
) {
    navigation(
        startDestination = Screen.MatchListTomorrow.route,
        route = Screen.Tomorrow.route
    ) {
        composable(Screen.MatchListTomorrow.route) {
            tomorrowScreenContent()
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