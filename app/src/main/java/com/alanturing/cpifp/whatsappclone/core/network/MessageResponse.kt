package com.alanturing.cpifp.whatsappclone.core.network

import com.alanturing.cpifp.whatsappclone.chat.data.Message
import kotlinx.datetime.Instant

data class MessageResponse(
    val id: Long,
    val text: String,
    val timeSent: Instant,
    val sender: ContactResponse,
    val receiver: ContactResponse
)

fun List<MessageResponse>.toExternalModel(): List<Message> {
    return this.map {
        Message(
            interlocutor = it.id,
            texto = it.text,
            /*fechaYHora = it.timeSent,
            sender = it.sender,
            receiver = it.receiver*/
        )
    }
} /**/
