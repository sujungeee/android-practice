package com.android.practice.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import com.android.practice.R

private const val TAG = "MyService_practice"
class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    private lateinit var mediaPlayer: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: ")
        mediaPlayer= MediaPlayer.create(this, R.raw.jazzbyrima)
        mediaPlayer.isLooping= true
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}