package com.arizonrp.gaming.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.arizonrp.gaming.R

class SplashActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var percentText: TextView
    private var progress = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        progressBar = findViewById(R.id.progressBar)
        percentText = findViewById(R.id.percentText)

        progressBar.progress = progress
        percentText.text = "$progress%"

        startLoadingAnimation()
    }

    private fun startLoadingAnimation() {
        val handler = Handler(Looper.getMainLooper())

        fun updateProgress() {
            if (progress < 100) {
                progress += (Math.random() * 2).toInt() + 1
                progress = minOf(progress, 100)

                progressBar.progress = progress
                percentText.text = "$progress%"

                handler.postDelayed({ updateProgress() }, (Math.random() * 500 + 100).toLong())
            } else {
                percentText.text = "جاهز!"
                handler.postDelayed({
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }, 500)
            }
        }

        handler.postDelayed({ updateProgress() }, 1500)
    }
}