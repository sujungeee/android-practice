package com.android.practice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.practice.bindService.LocalBindActivity
import com.android.practice.bindService.RemoteActivity
import com.android.practice.databinding.ActivityServiceBinding
import com.android.practice.service.StartServiceActivity

private const val TAG = "ServiceActivity_practice"
class ServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bindServiceLocalBtn.setOnClickListener {
            val intent= Intent(this, LocalBindActivity::class.java)
            startActivity(intent)
        }

        binding.bindServiceRemoteActivityBtn.setOnClickListener {
            val intent= Intent(this, RemoteActivity::class.java)
            startActivity(intent)
        }

        binding.bindServiceRemoteAidlBtn.setOnClickListener {

        }
    }
}