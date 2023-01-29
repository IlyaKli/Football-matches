package com.ilya.sporttest.navigation

import android.net.Uri
import com.google.gson.Gson
import com.ilya.sporttest.domain.model.Match

sealed class Screen(
    val route: String
) {
    object MatchListToday: Screen(ROUTE_MATCH_LIST_TODAY)

    object MatchListYesterday: Screen(ROUTE_MATCH_LIST_YESTERDAY)

    object MatchListTomorrow: Screen(ROUTE_MATCH_LIST_TOMORROW)

    object MatchInfo: Screen(ROUTE_MATCH_INFO) {

        private const val ROUTE_FOR_ARGS = "info"

        fun getRouteWithArgs(match: Match): String {
            val matchJson = Gson().toJson(match)
            return "$ROUTE_FOR_ARGS/${matchJson.encode()}"
        }
    }

    object Today: Screen(ROUTE_TODAY)

    object Yesterday: Screen(ROUTE_YESTERDAY)

    object Tomorrow: Screen(ROUTE_TOMORROW)

    companion object {

        const val KEY_MATCH = "match"

        const val ROUTE_MATCH_LIST_TODAY = "match_list_today"

        const val ROUTE_TODAY = "today"

        const val ROUTE_MATCH_LIST_YESTERDAY = "match_list_yesterday"

        const val ROUTE_YESTERDAY = "yesterday"

        const val ROUTE_MATCH_LIST_TOMORROW = "match_list_tomorrow"

        const val ROUTE_TOMORROW = "tomorrow"

        const val ROUTE_MATCH_INFO = "info/{$KEY_MATCH}"
    }
}

fun String.encode(): String {
    return Uri.encode(this)
}
