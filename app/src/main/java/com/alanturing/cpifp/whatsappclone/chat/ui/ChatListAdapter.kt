package com.alanturing.cpifp.whatsappclone.chat.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alanturing.cpifp.whatsappclone.R
import com.alanturing.cpifp.whatsappclone.chat.data.Chat
import com.alanturing.cpifp.whatsappclone.databinding.ChatListItemBinding

class ChatListAdapter(private val toChat: (View,Chat) -> Unit):
    ListAdapter<Chat, ChatListAdapter.ChatListItemViewHolder>(ChatDiff) {
    inner class ChatListItemViewHolder(private val binding: ChatListItemBinding): RecyclerView.ViewHolder(binding.root) {
        /*val textView: TextView
        init {
            textView = view.findViewById(R.id.textView)
        }*/
        fun bindTo(chat: Chat) {
            binding.chatName.text = chat.toName
            binding.root.setOnClickListener {
                toChat(binding.root,chat)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListItemViewHolder {
        val binding:ChatListItemBinding = ChatListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatListItemViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    //override fun getItemCount() = dataSet.size

    object ChatDiff: DiffUtil.ItemCallback<Chat>(){
        override fun areItemsTheSame(oldItem: Chat, newItem: Chat) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Chat, newItem: Chat) = oldItem.to == newItem.to
    }
}