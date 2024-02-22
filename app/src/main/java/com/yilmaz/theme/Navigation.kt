package com.yilmaz.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class NavigationGraph(val route: String) {
    data object SettingsScreen : NavigationGraph(route = "settings_screen")
}

@Composable
fun SetUpNavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationGraph.SettingsScreen.route
    ) {
        composable(
            route = NavigationGraph.SettingsScreen.route
        ) {
            SettingsScreen(navHostController)
        }
    }
}
