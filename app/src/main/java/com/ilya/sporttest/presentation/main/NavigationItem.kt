package com.ilya.sporttest.presentation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.ilya.sporttest.R
import com.ilya.sporttest.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) {
    object Today: NavigationItem(
        screen = Screen.MatchListToday,
        titleResId = R.string.navigation_item_today,
        icon = Icons.Filled.Home
    )

    object Yesterday: NavigationItem(
        screen = Screen.MatchListYesterday,
        titleResId = R.string.navigation_item_yesterday,
        icon = Icons.Filled.Favorite
    )

    object Tomorrow: NavigationItem(
        screen = Screen.MatchListTomorrow,
        titleResId = R.string.navigation_item_tomorrow,
        icon = Icons.Filled.Add
    )
}