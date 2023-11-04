package com.example.task_manager_4.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import com.example.task_manager_4.MainActivity
import com.example.task_manager_4.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class PushNotificationService : FirebaseMessagingService() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        Log.e("kiber", message.notification?.title.toString())
        Log.e("kiber", message.notification?.body.toString())


        val channel = NotificationChannel(
            CHANNEL_ID,
            "Heads Up Notification",
            NotificationManager.IMPORTANCE_HIGH
        )
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        val notification = Notification.Builder(this, CHANNEL_ID)
        notification.setSmallIcon(R.mipmap.ic_launcher)
        notification.setContentTitle(message.notification?.title)
        notification.setContentText(message.notification?.body)
        notification.setAutoCancel(false)

        NotificationManagerCompat.from(this).notify(1, notification.build());
    }

    companion object{
        const val CHANNEL_ID = "HEADS_UP_NOTIFICATION"
    }

}