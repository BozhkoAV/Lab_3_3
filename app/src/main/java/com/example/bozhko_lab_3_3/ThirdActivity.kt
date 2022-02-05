package com.example.bozhko_lab_3_3

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.bozhko_lab_3_3.databinding.ThirdActivityBinding

class ThirdActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ThirdActivityBinding.inflate(this.layoutInflater)
        binding.button4.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            // Если убрать этот флаг,
            // то всё равно останется только одна MainActivity,
            // так как для неё launchMode=singleTask
            /*i.apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }*/
            startActivity(i)
        }
        binding.button5.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            // Если убрать этот флаг,
            // то SecondActivity откроется поверх третьей (в Back Stack будет две SecondActivity),
            // так как для неё launchMode=singleTop
            i.apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(i)
        }

        drawerLayout = binding.drawerLayout

        binding.toolbar.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }

        binding.button8.setOnClickListener {
            drawerLayout.close()
            val i = Intent(this, AboutActivity::class.java)
            startActivity(i)
        }

        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.open_drawer_layout) {
            drawerLayout.open()
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }
}