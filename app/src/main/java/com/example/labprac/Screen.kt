package com.example.labprac

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen")
    object SelectCity : Screen(route = "select_city_screen")
    object WeatherDetail : Screen(route = "weather_detail_screen")
    object SplashScreen : Screen(route = "splash_screen")
    object splash : Screen(route = "splash")
    object GoogleButton : Screen(route = "google_button")
    object CoilImage: Screen(route = "coil_image")
}