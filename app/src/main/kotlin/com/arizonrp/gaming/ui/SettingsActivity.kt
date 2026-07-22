package com.arizonrp.gaming.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arizonrp.gaming.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val masterVolumeSeekBar = findViewById<SeekBar>(R.id.masterVolumeSeekBar)
        val musicVolumeSeekBar = findViewById<SeekBar>(R.id.musicVolumeSeekBar)
        val radioVolumeSeekBar = findViewById<SeekBar>(R.id.radioVolumeSeekBar)
        val masterVolumeText = findViewById<TextView>(R.id.masterVolumeText)
        val musicVolumeText = findViewById<TextView>(R.id.musicVolumeText)
        val radioVolumeText = findViewById<TextView>(R.id.radioVolumeText)
        val oldHeadSwitch = findViewById<Switch>(R.id.oldHeadSwitch)
        val oldRadarSwitch = findViewById<Switch>(R.id.oldRadarSwitch)
        val autoUpdateSwitch = findViewById<Switch>(R.id.autoUpdateSwitch)
        val saveButton = findViewById<Button>(R.id.saveSettingsBtn)
        val homeBtn = findViewById<ImageButton>(R.id.homeNav)
        val profileBtn = findViewById<ImageButton>(R.id.profileNav)

        masterVolumeSeekBar.progress = 85
        musicVolumeSeekBar.progress = 40
        radioVolumeSeekBar.progress = 65
        masterVolumeText.text = "85%"
        musicVolumeText.text = "40%"
        radioVolumeText.text = "65%"
        autoUpdateSwitch.isChecked = true

        masterVolumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                masterVolumeText.text = "$progress%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        musicVolumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                musicVolumeText.text = "$progress%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        radioVolumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                radioVolumeText.text = "$progress%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        saveButton.setOnClickListener {
            Toast.makeText(this, "تم حفظ الإعدادات", Toast.LENGTH_SHORT).show()
        }

        homeBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        profileBtn.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}