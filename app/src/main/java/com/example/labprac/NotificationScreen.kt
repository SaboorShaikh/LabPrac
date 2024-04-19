package com.example.labprac

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun NotificationScreen(navController: NavController, context: Context){
    val handler = NotificationHandler(context, ComponentActivity.NOTIFICATION_SERVICE)
    val intent = Intent(LocalContext.current, MyService::class.java)
    Column {
        Button(onClick = {
            //handler.postNotification(handler.createNotification())
            context.startForegroundService(intent)
        }) {
            Text(text = "Start Service")
        }
        Button(onClick = {
            handler.postNotification(handler.createNotification())
            context.stopService(intent)
        }) {
            Text(text = "Stop Service")
        }
    }
}