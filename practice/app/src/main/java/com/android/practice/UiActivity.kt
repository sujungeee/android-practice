package com.android.practice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.practice.databinding.ActivityUiBinding
import com.android.practice.ui.LayoutAttributeActivity
import com.android.practice.ui.ListViewActivity
import com.android.practice.ui.MenuActivity

private const val TAG = "UiActivity_practice"
class UiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ListView(ArrayAdatper, SimpleAdapter, CustomListAdapter)
        binding.listviewBtn.setOnClickListener {
            val intent= Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }

        binding.layoutAttributeBtn.setOnClickListener {
            val intent= Intent(this, LayoutAttributeActivity::class.java)
            startActivity(intent)
        }

        binding.menuBtn.setOnClickListener{
            val intent= Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}