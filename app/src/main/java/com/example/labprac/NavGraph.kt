package com.example.labprac

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SelectCity.route
    ) {
        composable(
            route = Screen.SelectCity.route
        ) {
            SelectCitScreen(navController)
        }
        composable(
            route = Screen.Detail.route
        ) {
            DetailScreen(navController)
        }
    }
}