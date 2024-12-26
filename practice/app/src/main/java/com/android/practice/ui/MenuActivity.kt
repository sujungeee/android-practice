package com.android.practice.ui

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.practice.R
import com.android.practice.databinding.ActivityMenuBinding
import java.util.zip.Inflater

private const val TAG = "MenuActivity_practice"
class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // long click 시 context 메뉴를 연결할 view 등록
        registerForContextMenu(binding.contextMenuBtn)

        // 3. popup menu
        binding.popupMenuBtn.setOnClickListener {
            val popupMenu = PopupMenu(applicationContext, it)
            menuInflater.inflate(R.menu.menu_popup, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.popup_menu1 -> {
                        Toast.makeText(this@MenuActivity, "메뉴 1 클릭", Toast.LENGTH_SHORT).show()
                    }
                    R.id.popup_menu2 -> {
                        Toast.makeText(this@MenuActivity, "메뉴 2 클릭", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(this@MenuActivity, "메뉴 3 클릭", Toast.LENGTH_SHORT).show()
                    }
                }
                false
            }
            popupMenu.show();
        }
    }

    // 1. options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater= menuInflater
        inflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // 전달된 MenuItem의 id로 아이템 구분
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_exit){
            finish()
        } else {
            Toast.makeText(this, "Hello menu, ${item.title}", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }

    // 2. context menu
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.context_menu_blue -> binding.contextMenuBtn.setTextColor(Color.BLUE)
            R.id.context_menu_red -> binding.contextMenuBtn.setTextColor(Color.RED)
            R.id.context_menu_green -> binding.contextMenuBtn.setTextColor(Color.GREEN)
        }
        return super.onContextItemSelected(item)
    }
}