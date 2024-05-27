package com.alanturing.cpifp.whatsappclone.register.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alanturing.cpifp.whatsappclone.MainActivity
import com.alanturing.cpifp.whatsappclone.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?/*, persistentState: PersistableBundle?*/) {
        super.onCreate(savedInstanceState/*, persistentState*/)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root/*R.layout.activity_register*/)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.usuario.collect { uiState ->
                    // Hacer cosas cuando cambie user
                    /*if (usuario.phone.isNotBlank()) {
                        finish()
                    }*/
                    binding.progressIndicator.visibility = View.GONE
                    binding.registerInput.error = null
                    when(uiState) {
                        is UiState.started -> {}
                        is UiState.error -> {
                            binding.registerInput.error = uiState.error
                        }
                        is UiState.loading -> {
                            binding.progressIndicator.visibility = View.VISIBLE
                        }
                        is UiState.success -> {
                            startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                            finish()
                        }
                    }
                }
            }
        }

        binding.registerButton.setOnClickListener {
            binding.registerInput.error = null
            if (binding.textInput.text.isNullOrBlank()) {
                binding.registerInput.error = "Debe indicar un telefono"
            }
        }

        val userInput = binding.registerInput
    }
}