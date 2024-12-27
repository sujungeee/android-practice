package com.android.practice.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

private const val TAG = "LocaleChangeReceiver_practice"
class LocaleChangeReceiver : BroadcastReceiver() {
    // 정적 리시버 등록
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "onReceive: receive 받기: ${intent.action}")
    }
}