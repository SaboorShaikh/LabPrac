package com.example.labprac

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen")
    object SelectCity : Screen(route = "select_city_screen")
    object WeatherDetail : Screen(route = "weather_detail_screen")

}