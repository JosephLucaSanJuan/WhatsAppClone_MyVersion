package com.alanturing.cpifp.whatsappclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.alanturing.cpifp.whatsappclone.register.ui.RegisterActivity
import com.alanturing.cpifp.whatsappclone.register.ui.RegisterViewModel

class SplashScreenActivity : AppCompatActivity() {
    private val viewModel:RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val intent:Intent = if (!viewModel.isRegistered()) {
            // Navegar a RegisterActivity
            Intent(this,RegisterActivity::class.java)
        } else {
            Intent(this,MainActivity::class.java)
        }
    }
}