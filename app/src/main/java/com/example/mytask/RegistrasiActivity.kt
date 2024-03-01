package com.example.mytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegistrasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)
        supportActionBar?.hide()
    }
}