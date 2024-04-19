package com.example.labprac

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

class NotificationHandler(private val context: Context, private val SERVICE_NAME: String) {
    val CHANNEL_ID = "ABC1234"
    val CHENNEL_NAME = "MAD-SEC C posts"


    //        @RequiresApi(Build.VERSION_CODES.O)
    fun createNotification(): Notification {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val notification = Notification.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.logo)
            .setContentTitle("Favourite")
            .setContentText("This is just a test notification")
            .setContentIntent(pendingIntent)
            .build()
        return notification
    }

    fun postNotification(notification: Notification) {
        val manager = context.getSystemService(SERVICE_NAME) as NotificationManager

        val channel =
            NotificationChannel(CHANNEL_ID, CHENNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)

        manager.createNotificationChannel(channel)
        if (context.checkSelfPermission(
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            manager.notify(1234, notification)
        }
    }
}
