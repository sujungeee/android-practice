package com.android.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.practice.databinding.ActivityMainBinding

private const val TAG = "MainActivity_practice"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainBtn.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java).apply {
                putExtra("to_sub", "main에서 왔어요.")
            }
//            startActivity(intent)
            requestActivity.launch(intent)
        }
    }

    private val requestActivity= registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK){
            val intent= result.data
            val returnValue= intent?.getStringExtra("to_main")
            Toast.makeText(this, returnValue, Toast.LENGTH_SHORT).show()
        }
    }
}