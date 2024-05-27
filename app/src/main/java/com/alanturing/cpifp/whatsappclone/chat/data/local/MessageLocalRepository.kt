package com.alanturing.cpifp.whatsappclone.chat.data.local

import com.alanturing.cpifp.whatsappclone.chat.data.Message
import com.alanturing.cpifp.whatsappclone.chat.data.MessageRepositoryInterface

class MessageLocalRepository(
    private val messageDao: MessageDao
):MessageRepositoryInterface {
    override suspend fun getMessages(): List<Message> {
        val messages = messageDao.getAllMessages()
        return messages.toExternalModel()
    }

    override suspend fun createMessages(messages: List<Message>) {
        TODO("Not yet implemented")
    }
}