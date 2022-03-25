package com.example.bozhko_lab_3_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bozhko_lab_3_3.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAboutBinding.inflate(this.layoutInflater)

        binding.bnToThird.setOnClickListener {
            val i = Intent(this, ThirdActivity::class.java)
            i.apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            startActivity(i)
        }

        setContentView(binding.root)
    }
}