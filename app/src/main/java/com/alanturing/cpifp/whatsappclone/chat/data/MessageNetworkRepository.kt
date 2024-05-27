package com.alanturing.cpifp.whatsappclone.chat.data

import com.alanturing.cpifp.whatsappclone.core.network.WhatsAppCloneService
import com.alanturing.cpifp.whatsappclone.core.network.toExternalModel
import javax.inject.Inject

class MessageNetworkRepository @Inject constructor(
    private val networkService: WhatsAppCloneService
):MessageRepositoryInterface {
    override suspend fun getMessages(): List<Message/*Repository*/> {
        val messages = networkService.getAllMessages()
        return if (messages.isSuccessful) messages.body()!!.toExternalModel()
                else emptyList()
    }

    override suspend fun createMessages(messages: List<Message>) {
        TODO("Not yet implemented")
    }
}