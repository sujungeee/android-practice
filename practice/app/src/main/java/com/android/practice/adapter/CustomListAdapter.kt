package com.android.practice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.android.practice.R
import org.w3c.dom.Text

class CustomListAdapter(val context:Context, var items: List<Map<String, String>>, val layout: Int)
    : BaseAdapter(){

    override fun getView(p0: Int, p1: View?, parent: ViewGroup?): View {
        // xml -> java로 inflate
        val inflater= LayoutInflater.from(context)
        val view= inflater.inflate(layout, parent, false)

        // view에 값 변경
        view.findViewById<TextView>(R.id.tvId).text= items.get(p0).get("id")
        view.findViewById<TextView>(R.id.tvName).text= items.get(p0).get("name")

        return view
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): Any {
        return items.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
}
