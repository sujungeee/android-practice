package com.android.practice.broadcastReceiver

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.practice.R
import com.android.practice.databinding.ActivityBroadcastReceiverBinding
import com.ssafy.receiver.DynamicBroadcastActivity

private const val TAG = "BroadcastReceiverActivi_practice"
class BroadcastReceiverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBroadcastReceiverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 동적 브로드캐스트 리시버
        binding.dynamicBcBtn.setOnClickListener {
            val intent= Intent(this, DynamicBroadcastActivity::class.java)
            startActivity(intent)
        }

        // 2. 사용자 정의 브로드캐스트 리시버
        binding.userBcBtn.setOnClickListener {
            val intent = Intent(this, NewsReceiver::class.java) // 사용자 정의 리시버 지정
            intent.action = "example.MY"
            intent.putExtra("content", "오늘도 티끌을 모아봅니다.")

            sendBroadcast(intent)
            Log.d(TAG, "onCreate: 발송 완료")
        }

        // 3. 사용자 정의 permission 브로드캐스트 리시버
        binding.userPermissionBcBtn.setOnClickListener {
            val intent = Intent(this, UserPermissionReceiver::class.java)
            intent.action = "com.android.practice.news.funny"
            intent.putExtra("content", "오늘도 티끌을 모아봅니다.")

            sendBroadcast(intent)
            Log.d(TAG, "onCreate: 발송 완료")
        }
    }
}