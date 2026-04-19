package com.ctb.design.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun TakeHomeNavHost(
    navController: NavHostController,
    startRoute: String
) {
    NavHost(
        navController = navController,
        startDestination = startRoute
    ) {
        // Navigation routes will be added by features
    }
}
