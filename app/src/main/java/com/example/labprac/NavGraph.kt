package com.example.labprac

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Notification.route
    ) {
        composable(
            route = Screen.splash.route
        ) {
            splash(navController)
        }
        composable(
            route = Screen.GoogleButton.route
        ) {
            GoogleButton(
                navController,
                onClicked = {}
            )
        }
        composable(
            route = Screen.SelectCity.route
        ) {
            GoogleButton(
                navController,
                onClicked = {}
            )
        }
        composable(
            route = Screen.Detail.route
        ) {
            DetailScreen(navController)
        }
        composable(
            route = Screen.CoilImage.route
        ) {
            CoilImage(navController)
        }
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController)
        }
        composable(
            route = Screen.Gradient.route
        ){
            GradientButton(onClick = { /*TODO*/ }, navController = navController)
        }
        composable(
            route = Screen.Notification.route
        ){
            NotificationScreen(navController, context = LocalContext.current)
        }
    }
}