package com.android.practice.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyForeService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}