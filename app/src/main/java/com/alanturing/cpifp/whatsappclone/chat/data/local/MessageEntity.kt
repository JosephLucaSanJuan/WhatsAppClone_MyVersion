package com.alanturing.cpifp.whatsappclone.chat.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alanturing.cpifp.whatsappclone.chat.data.Message

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey val id: Long,
    val text: String
)

fun List<MessageEntity>.toExternalModel(): List<Message> {
    return this.map {
        Message(
            interlocutor = it.id,
            texto = it.text
        )
    }
}/**/