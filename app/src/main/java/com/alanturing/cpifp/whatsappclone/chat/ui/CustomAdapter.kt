package com.alanturing.cpifp.whatsappclone.chat.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alanturing.cpifp.whatsappclone.R
import com.alanturing.cpifp.whatsappclone.chat.data.Chat
import com.alanturing.cpifp.whatsappclone.chat.data.ChatRepository

class CustomAdapter(private val dataSet: List<Chat>):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.textView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}