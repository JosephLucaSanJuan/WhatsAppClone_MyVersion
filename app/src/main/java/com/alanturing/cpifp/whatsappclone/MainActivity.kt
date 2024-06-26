package com.alanturing.cpifp.whatsappclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.alanturing.cpifp.whatsappclone.chat.data.ChatRepository
import com.alanturing.cpifp.whatsappclone.chat.ui.ChatListAdapter
import com.alanturing.cpifp.whatsappclone.chat.ui.MessageListAdapter
import com.alanturing.cpifp.whatsappclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val navigationBar = binding.bottomNav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navControlller = navHostFragment.navController
        navigationBar.setupWithNavController(navControlller)

        /*val dataset = ChatRepository.getInstance()
        val customAdapter = ChatListAdapter(dataset)*/

        val customAdapter = MessageListAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.fragment_container)
        recyclerView.adapter = customAdapter
    }
}