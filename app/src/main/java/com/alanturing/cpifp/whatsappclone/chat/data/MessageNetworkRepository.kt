package com.alanturing.cpifp.whatsappclone.chat.data

import com.alanturing.cpifp.whatsappclone.core.network.toInternalModel
import com.alanturing.cpifp.whatsappclone.core.network.WhatsAppCloneService
import com.alanturing.cpifp.whatsappclone.core.network.toExternalModel
import com.alanturing.cpifp.whatsappclone.register.data.RegisterRepository
import javax.inject.Inject

class MessageNetworkRepository @Inject constructor(
    private val networkService: WhatsAppCloneService,
    private val registerRepository: RegisterRepository
):MessageRepositoryInterface {
    override suspend fun getMessages(): List<Message/*Repository*/> {
        val messages = networkService.getAllMessages()
        return if (messages.isSuccessful) messages.body()!!.toExternalModel()
                else emptyList()
    }

    override suspend fun createMessages(messages: List<Message>) {
        val message = messages.toInternalModel(registerRepository).forEach {
            networkService.createMessage(it)
        }
        return message
    }

    override suspend fun readMessages(): List<Message> {
        TODO("Not yet implemented")
    }
}