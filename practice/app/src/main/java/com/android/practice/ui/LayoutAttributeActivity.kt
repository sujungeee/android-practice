package com.android.practice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.practice.databinding.ActivityLayoutAttributeBinding

private const val TAG = "GravityActivity_practice"
class LayoutAttributeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLayoutAttributeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLayoutAttributeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}