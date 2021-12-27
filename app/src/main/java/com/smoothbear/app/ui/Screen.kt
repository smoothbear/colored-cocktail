package com.smoothbear.app.ui

import com.smoothbear.app.ui.main.NavigationItem

sealed class Screen(val route: String) {

    object Main : Screen("main/{page}") {
        fun createRoute(page: NavigationItem) = "main/${page.route}"
    }

    object Detail : Screen("{whiskeyId}/detail") {
        fun createRoute(cockTailId: Int) = "$cockTailId/detail"
    }
}
