package com.alanturing.cpifp.whatsappclone.chat.data

interface MessageRepositoryInterface {
    suspend fun getMessages(): List<Message>

    suspend fun createMessages(messages: List<Message>)

    suspend fun readMessages(): List<Message>
}