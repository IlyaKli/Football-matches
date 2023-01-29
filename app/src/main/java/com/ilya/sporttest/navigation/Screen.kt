package com.ilya.sporttest.navigation

sealed class Screen(
    val route: String
) {
    object Splash: Screen(ROUTE_SPLASH)

    object MatchListToday: Screen(ROUTE_MATCH_LIST_TODAY)

    object MatchListYesterday: Screen(ROUTE_MATCH_LIST_YESTERDAY)

    object MatchListTomorrow: Screen(ROUTE_MATCH_LIST_TOMORROW)

    object MatchInfo: Screen(ROUTE_MATCH_INFO)

    object Web: Screen(ROUTE_WEB)

    private companion object {

        const val ROUTE_SPLASH = "splash"

        const val ROUTE_MATCH_LIST_TODAY = "match_list_today"

        const val ROUTE_MATCH_LIST_YESTERDAY = "match_list_yesterday"

        const val ROUTE_MATCH_LIST_TOMORROW = "match_list_tomorrow"

        const val ROUTE_MATCH_INFO = "match_info"

        const val ROUTE_WEB = "web"
    }
}
