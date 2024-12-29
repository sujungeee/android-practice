package com.android.practice.bindService

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.practice.R
import com.android.practice.databinding.ActivityLocalBindBinding

private const val TAG = "LocalBindActivity_practice"
class LocalBindActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocalBindBinding

    private var isBound= false
    private lateinit var boundService: BoundService

    private val connection= object: ServiceConnection { // 2
        // 연결에 성공할 때
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d(TAG, "onServiceConnected: ")
            isBound= true
            val binder= service as BoundService.MyLocalBinder
            boundService= binder.getService() // 3
        }

        // 연결이 끊어질 때
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "onServiceDisconnected: ")
            isBound= false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLocalBindBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            if(isBound){ // 4
                binding.textView2.text= boundService.getCurrentTime()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
        val intent= Intent(this, BoundService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE) // 1
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
        unbindService(connection)
    }
}