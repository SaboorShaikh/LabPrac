package com.example.labprac

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun splash(
    navController: NavController
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate(Screen.SplashScreen.route)
//            startActivity(
//                Intent(
//                    this@SplashActivity,
//                    MainActivity::class.java
//                )
//            )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
    }
}