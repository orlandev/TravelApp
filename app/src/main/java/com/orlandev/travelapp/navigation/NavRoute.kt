package com.orlandev.travelapp.navigation

sealed class NavRoute(
    val route: String
) {
    object HomeScreenRoute : NavRoute(route = "home_screen")
    object DetailScreenRoute : NavRoute(route = "detail_screen")
}
