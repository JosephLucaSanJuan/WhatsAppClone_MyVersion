package com.alanturing.cpifp.whatsappclone.chat.data.local

import com.alanturing.cpifp.whatsappclone.chat.data.Message
import com.alanturing.cpifp.whatsappclone.chat.data.MessageRepositoryInterface
import javax.inject.Inject

class MessageLocalRepository @Inject constructor(
    private val messageDao: MessageDao
):MessageRepositoryInterface {
    override suspend fun getMessages(): List<Message> {
        val messages = messageDao.getAllMessages()
        return messages.toExternalModel()
    }

    override suspend fun createMessages(messages: List<Message>) {
        messages.toInternalModel().forEach {
            messageDao.createMessage(it)
        }
    }

    override suspend fun readMessages(): List<Message> {
        val messages = messageDao.getAllMessages()
        return messages.toExternalModel()
    }
}