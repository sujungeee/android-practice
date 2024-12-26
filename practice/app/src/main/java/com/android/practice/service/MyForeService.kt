package com.android.practice.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.android.practice.MainActivity
import com.android.practice.R

private const val TAG = "MyForeService_practice"
class MyForeService : Service() {

    private lateinit var mp: MediaPlayer

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate: ")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        mp.stop() //음악 중지
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: ${intent?.getStringExtra("hello")}")
        startForegroundService()
        mp = MediaPlayer.create(this, R.raw.jazzbyrima)
        mp.isLooping=true
        mp.start()
        return START_REDELIVER_INTENT
    }

    private fun startForegroundService() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notificationIntent = Intent(this, StartServiceActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE)
        val builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val CHANNEL_ID = "notification_channel"
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Notification Channel",
                NotificationManager.IMPORTANCE_LOW // 알람만 (소리 X)
            )
            manager.createNotificationChannel(channel)
            NotificationCompat.Builder(this, CHANNEL_ID)
        } else {
            NotificationCompat.Builder(this)
        }

        builder.setSmallIcon(R.drawable.ic_outline_play_arrow_24)
            .setContentTitle("MyMusic Foreground")
            .setContentText("music play.....")
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
        startForeground(101, builder.build())
    }
}