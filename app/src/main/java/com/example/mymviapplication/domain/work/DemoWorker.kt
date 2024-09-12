package com.example.mymviapplication.domain.work

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.work.Worker
import androidx.work.WorkerParameters

import com.example.mymviapplication.R
import com.example.mymviapplication.presentation.view.MainActivity
import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.properties.Delegates

class DemoWorker(
    private val appContext: Context, params: WorkerParameters
) : Worker(appContext, params) {
    private val notificationChannelId = "DemoNotificationChannelId"
    override fun doWork(): Result {
        // Use
        Timer().schedule(10000) {
            if (ActivityCompat.checkSelfPermission(
                    appContext,
                    Manifest.permission.POST_NOTIFICATIONS
                )
                == PackageManager.PERMISSION_GRANTED
            ) {
                with(NotificationManagerCompat.from(applicationContext)) {
                    notify(0, createNotification())
                }
            }
        }
        Log.d("DemoWorker", "do work done!")
        return Result.success()
    }

    private fun createNotificationChannel() {
        val notificationChannel = NotificationChannel(
            notificationChannelId, "DemoWorker", NotificationManager.IMPORTANCE_DEFAULT
        )
        val notificationManager: NotificationManager? = getSystemService(
            applicationContext, NotificationManager::class.java
        )
        notificationManager?.createNotificationChannel(notificationChannel)
    }

    private fun createNotification(): Notification {
        createNotificationChannel()
        val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)
        var pendingIntentFlag by Delegates.notNull<Int>()
        pendingIntentFlag = PendingIntent.FLAG_IMMUTABLE
        val mainActivityPendingIntent = PendingIntent.getActivity(
            applicationContext, 0, mainActivityIntent, pendingIntentFlag
        )
        return NotificationCompat.Builder(
            applicationContext,
            notificationChannelId
        )
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(applicationContext.getString(R.string.app_name))
            .setContentText("Work Request Done!")
            .setContentIntent(mainActivityPendingIntent)
            .setAutoCancel(true)
            .build()
    }
}