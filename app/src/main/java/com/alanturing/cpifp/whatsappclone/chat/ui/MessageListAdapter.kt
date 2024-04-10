package com.alanturing.cpifp.whatsappclone.chat.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alanturing.cpifp.whatsappclone.chat.data.Contact
import com.alanturing.cpifp.whatsappclone.chat.data.Message
import com.alanturing.cpifp.whatsappclone.databinding.MessageListItemBinding

class MessageListAdapter(private val toChat: (View, Message) -> Unit):
    ListAdapter<Message, MessageListAdapter.MessageListItemViewHolder>(MessageDiff) {
    inner class MessageListItemViewHolder(private val binding: MessageListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindTo(message: Message) {
            binding.messageText.text = message.texto
            binding.root.setOnClickListener {
                toChat(binding.root,message)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageListItemViewHolder {
        val binding: MessageListItemBinding = MessageListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MessageListItemViewHolder(binding)
    }

    override fun onBindingViewHolder(holder: MessageListItemViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    object MessageDiff:DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact) = oldItem.id == newItem.id
    }
}