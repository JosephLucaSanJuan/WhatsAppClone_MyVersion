package com.alanturing.cpifp.whatsappclone.chat.data

import javax.inject.Singleton

@Singleton
class ChatRepository {

    private val _chats: MutableList<Chat> = mutableListOf()
    val chats: List<Chat>
        get() = _chats.toList()

    /*init {
        _chats.add(Chat("", 1,"David Hormigo"))
        _chats.add(Chat("", 2, "Pepe Periañez"))
        _chats.add(Chat("", 15,"Juan Marcial"))
    }*/

    fun  createChat(contact: Contact) {
        _chats.add(Chat("",
                        contact.id,
                        "${contact.name}"))
    }
}