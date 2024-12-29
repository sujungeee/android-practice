package com.android.practice.bindService

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.util.Date

private const val TAG = "BoundService_practice"
class BoundService : Service() {
    private val myBinder: IBinder= MyLocalBinder()

    override fun onBind(intent: Intent?): IBinder {
        return myBinder
    }

    inner class MyLocalBinder: Binder() { // Binder implements IBinder
        fun getService(): BoundService= this@BoundService
    }

    // CRUD가 여기에 옴. Activity는 이것을 내 것처럼 호출함
    fun getCurrentTime(): String{
        Log.d(TAG, "getCurrentTime: ")
        return "현재 시간은: ${Date()}"
    }
}