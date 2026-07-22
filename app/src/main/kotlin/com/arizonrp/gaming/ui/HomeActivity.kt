package com.arizonrp.gaming.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arizonrp.gaming.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val enterButton = findViewById<Button>(R.id.enterServerBtn)
        val settingsBtn = findViewById<ImageButton>(R.id.settingsNav)
        val profileBtn = findViewById<ImageButton>(R.id.profileNav)

        enterButton.setOnClickListener {
            Toast.makeText(this, "جاري الدخول للسيرفر...", Toast.LENGTH_SHORT).show()
        }

        settingsBtn.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        profileBtn.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}