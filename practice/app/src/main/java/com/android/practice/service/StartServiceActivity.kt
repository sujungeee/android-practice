package com.android.practice.service

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.practice.R
import com.android.practice.databinding.ActivityStartServiceBinding

private const val TAG = "StartServiceActivity_practice"
class StartServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "서비스 테스트 예제"
//      val intent = Intent(this, MyMusicService::class.java)

        // 알림 허용 팝업권한 체크 & 팝업 띄우기.
        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
        Log.d(TAG, "onCreate: $permission")
        if(permission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 100)
        }

        val intent = Intent(this, MyService::class.java)

        binding.startServiceBtn.setOnClickListener {
            intent.putExtra("hello", "from Activity")
            startService(intent)
            Log.d(TAG, "onCreate: startService()")
        }

        binding.stopServiceBtn.setOnClickListener {
            stopService(intent);
            Log.d(TAG, "onCreate: StopService()")
        }

        val foreIntent= Intent(this, MyForeService::class.java)

        binding.foreStartServiceBtn.setOnClickListener {
            intent.putExtra("hello", "from Activity")
            startService(foreIntent)
            Log.d(TAG, "onCreate: startService()")
        }

        binding.foreStopServiceBtn.setOnClickListener {
            stopService(foreIntent);
            Log.d(TAG, "onCreate: StopService()")
        }
    }
}