package com.android.practice.ui

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.practice.adapter.CustomListAdapter
import com.android.practice.databinding.ActivityListViewBinding

private const val TAG = "ListViewActivity_practice"
class ListViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListViewBinding

    private val strData = mutableListOf<String>()
    private val mapData = mutableListOf<Map<String, String>>()
    private lateinit var selectedTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for(i in 1..10){
            strData.add("data $i")
            mapData.add(mapOf("id" to "hong $i", "name" to "홍길동 $i"))
        }

        val adapter1 = ArrayAdapter(this, R.layout.simple_list_item_1, strData)
        binding.listview1.adapter = adapter1

        binding.listview1.setOnItemClickListener { parent, view, position, id ->
            selectedTv.text = parent.adapter.getItem(position).toString()
            Log.d(TAG, "onCreate: ${parent.adapter.getItem(position)}")
        }

        val adapter2 = SimpleAdapter(
            this,
            mapData,
            R.layout.simple_list_item_2,
            arrayOf("id", "name"),
            intArrayOf(R.id.text1, R.id.text2)
        )
        binding.listview2.adapter = adapter2
        binding.listview2.setOnItemClickListener { parent, view, position, id ->
            selectedTv.text = parent.adapter.getItem(position).toString()
            Log.d(TAG, "onCreate: ${parent.adapter.getItem(position)}")
        }

        val adapter3 =
            CustomListAdapter(this, mapData, com.android.practice.R.layout.list_item_layout)
        binding.listview3.adapter = adapter3
        binding.listview3.setOnItemClickListener { parent, view, position, id ->
            selectedTv.text = parent.adapter.getItem(position).toString()
            Log.d(TAG, "onCreate: ${parent.adapter.getItem(position)}")
        }
    }
}