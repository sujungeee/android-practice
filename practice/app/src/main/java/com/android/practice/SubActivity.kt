package com.android.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.practice.databinding.ActivitySubBinding

private const val TAG = "SubActivity_practice"
class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.subTitle.text= intent.getStringExtra("to_sub")

        binding.subBtn.setOnClickListener {
            val intent= Intent().apply{
                putExtra("to_main", "sub에서 왔어요.")
            }

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}