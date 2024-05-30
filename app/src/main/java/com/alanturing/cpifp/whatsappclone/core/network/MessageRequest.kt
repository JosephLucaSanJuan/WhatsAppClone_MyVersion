package com.alanturing.cpifp.whatsappclone.core.network

import com.alanturing.cpifp.whatsappclone.chat.data.Message
import com.alanturing.cpifp.whatsappclone.register.data.RegisterRepository
import java.time.Instant

data class MessageRequest(
    val text: String,
    val timeSent: String,
    val senderPhone: String,
    val receiverPhone: String
)

suspend fun List<Message>.toInternalModel(registerRepository: RegisterRepository): List<MessageRequest> {
    return this.map {
        MessageRequest(
            text = it.texto,
            timeSent = Instant.now().toString(),
            senderPhone = registerRepository.getUser(),
            receiverPhone = registerRepository.getUser()
        )
    }
}
