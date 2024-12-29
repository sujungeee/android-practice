package com.android.remote_binder

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.util.Log
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

private const val TAG = "MyRemoteService_practice"
class MyRemoteService : Service() {

    // Handler를 이용해 만든 Messenger를 이용해 클라이언트에 반환될 iBinder 객체 반환한다.
    override fun onBind(intent: Intent): IBinder {
        val messenger = Messenger(object : Handler( Looper.myLooper()!! ) { // looper: 메인 스레드 큐로 들어온 mythread를 꺼내주는 동작을 함, 꺼내진 data?를 handler가 처리
            // 메시지를 수신했을 때 처리할 동작 구현
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val data = msg.data
                val str = data.getString("MyString")
                Toast.makeText(applicationContext, "${str} \n ${getFormattedDate()}" , Toast.LENGTH_SHORT).show()
                Log.d(TAG, "handleMessage: ${str}")
            }

            private fun getFormattedDate() : String {
                val format = SimpleDateFormat("yyyy-MM-dd kk:mm:ss E", Locale.KOREAN) //format 설정
                format.timeZone = TimeZone.getTimeZone("Asia/Seoul") //TimeZone  설정 (GMT +9)

                //현재시간에 적용
                return format.format(Date().time)
            }
        })
        return messenger.binder
    }

}