package com.alanturing.cpifp.whatsappclone.chat.data

import java.time.Clock
import javax.inject.Singleton

@Singleton
class MessageRepository {
    private val mensajes: MutableList<Message> = mutableListOf()
    val messages: List<Message>
        get() = mensajes.toList()

    fun addMessage(message: Message){
        mensajes.add(
            Message("",
                             "",
                             Clock.System.now(),
                             true)
        )
    }
}