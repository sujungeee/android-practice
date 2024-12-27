package com.android.practice

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.practice.broadcastReceiver.LocaleChangeReceiver
import com.android.practice.databinding.ActivityStartBinding
import com.android.practice.service.StartServiceActivity
import com.android.practice.ui.ListViewActivity

private const val TAG = "StartActivity_practice"
class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. anonymous nested class로 event handler 구현
//        binding.eventBtn.setOnClickListener( object: View.OnClickListener {
//            override fun onClick(v: View) {
//                Toast.makeText(this@StartActivity, "Hello World", Toast.LENGTH_SHORT).show()
//            }
//        })

        // 2. 람다식 적용하기
//        binding.eventBtn.setOnClickListener({ v: View? ->
//            Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
//        })

        // 3. 최종 코드
        binding.eventBtn.setOnClickListener {
            Toast.makeText(this, "Hello World" + it.javaClass.name, Toast.LENGTH_SHORT).show()
        }

        // 안드로이드 UI
        binding.uiBtn.setOnClickListener {
            val intent= Intent(this, UiActivity::class.java)
            startActivity(intent)
        }

        // 서비스 컴포넌트
        binding.serviceBtn.setOnClickListener {
            val intent= Intent(this, StartServiceActivity::class.java)
            startActivity(intent)
        }

        // 브로드캐스트리시버 컴포넌트
        binding.broadcastReceiverBtn.setOnClickListener {
            val intent= Intent(this, LocaleChangeReceiver::class.java)
            startActivity(intent)
        }
    }
}