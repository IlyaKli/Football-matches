package com.ilya.sporttest.presentation.main

import com.ilya.sporttest.R
import com.ilya.sporttest.presentation.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val iconId: Int
) {
    object Today: NavigationItem(
        screen = Screen.MatchListToday,
        titleResId = R.string.navigation_item_today,
        iconId = R.drawable.ic_ball
    )

    object Yesterday: NavigationItem(
        screen = Screen.MatchListYesterday,
        titleResId = R.string.navigation_item_yesterday,
        iconId = R.drawable.ic_ball
    )

    object Tomorrow: NavigationItem(
        screen = Screen.MatchListTomorrow,
        titleResId = R.string.navigation_item_tomorrow,
        iconId = R.drawable.ic_ball
    )
}