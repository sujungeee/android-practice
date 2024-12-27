package com.android.practice.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

private const val TAG = "NewsReceiver_practice"
class NewsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "onReceive: receive 받기: ${intent.action}")
        Log.d(TAG, "onReceive: extra: ${intent.getStringExtra("content")}")
    }
}