package com.arizonrp.gaming.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.arizonrp.gaming.R
import com.bumptech.glide.Glide

class ProfileActivity : AppCompatActivity() {
    private lateinit var profileImage: ImageView
    private lateinit var playerNameEdit: EditText
    private lateinit var editButton: ImageButton
    private lateinit var saveButton: Button
    private lateinit var homeBtn: ImageButton
    private lateinit var settingsBtn: ImageButton

    private var selectedImageUri: Uri? = null

    private val galleryLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            selectedImageUri = it
            Glide.with(this)
                .load(it)
                .circleCrop()
                .into(profileImage)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profileImage = findViewById(R.id.profileImage)
        playerNameEdit = findViewById(R.id.playerNameEdit)
        editButton = findViewById(R.id.editProfileBtn)
        saveButton = findViewById(R.id.saveChangesBtn)
        homeBtn = findViewById(R.id.homeNav)
        settingsBtn = findViewById(R.id.settingsNav)

        editButton.setOnClickListener {
            checkPermissionAndOpenGallery()
        }

        saveButton.setOnClickListener {
            val playerName = playerNameEdit.text.toString()
            if (playerName.isNotEmpty()) {
                Toast.makeText(this, "تم حفظ التغييرات", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "الرجاء إدخال اسم اللاعب", Toast.LENGTH_SHORT).show()
            }
        }

        homeBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        settingsBtn.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun checkPermissionAndOpenGallery() {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            android.Manifest.permission.READ_MEDIA_IMAGES
        } else {
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        }

        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            galleryLauncher.launch("image/*")
        } else {
            requestPermissions(arrayOf(permission), PERMISSION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE && grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            galleryLauncher.launch("image/*")
        }
    }

    companion object {
        const val PERMISSION_REQUEST_CODE = 101
    }
}