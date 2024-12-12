package com.android.practice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.practice.databinding.ActivityGravityBinding

private const val TAG = "GravityActivity_practice"
class ViewAttributeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGravityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGravityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}