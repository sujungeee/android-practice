package com.android.practice.bindService

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.practice.R
import com.android.practice.databinding.ActivityRemoteBinding

private const val TAG = "RemoteActivity_practice"
class RemoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRemoteBinding

    private var myService: Messenger? = null
    private var isBound = false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            myService = Messenger(p1) // Messenger: remote 통신용으로 만들어진 것을 사용
            isBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            myService = null
            isBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        // 서비스 바인딩 처리
        if (!isBound) {
            val target = ComponentName("com.android.remote_binder", "com.android.remote_binder.MyRemoteService")
            Intent().setComponent(target).also { intent ->
                bindService(intent, connection, Context.BIND_AUTO_CREATE)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        if (isBound) {
            unbindService(connection)
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRemoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            sendMessage()
        }
    }

    fun sendMessage() {
        if (!isBound) return
        val msg = Message.obtain()
        msg.data = Bundle().apply { putString("MyString", "This is Message") }
        // 서비스의 사용
        myService?.send(msg)
    }
}