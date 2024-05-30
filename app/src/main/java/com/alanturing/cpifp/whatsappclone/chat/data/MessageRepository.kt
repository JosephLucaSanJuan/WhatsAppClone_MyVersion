package com.alanturing.cpifp.whatsappclone.chat.data

import android.widget.Adapter
import com.alanturing.cpifp.whatsappclone.chat.data.local.toInternalModel
import java.time.Clock
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageRepository /*@Inject*/ constructor(
    private val networkRepository: MessageRepositoryInterface,
    private val localRepository: MessageRepositoryInterface
): MessageRepositoryInterface {
    /*private val mensajes: MutableList<Message> = mutableListOf()
    val messages: List<Message>
        get() = mensajes.toList()

    fun addMessage(message: Message){
        mensajes.add(
            Message(1,
                    "",
                    kotlinx.datetime.Clock.System.now(),
                    true)
        )
    }*/

    override suspend fun getMessages(/*sender:Long*/): List<Message> {
        val response = networkRepository.getMessages()
        createMessages(response)
        return localRepository.getMessages()//mensajes.filter { it.interlocutor == sender }
    }

    override suspend fun createMessages(messages: List<Message>) {
        messages.toInternalModel().forEach {
            networkRepository.createMessages(messages)
        }
        return localRepository.createMessages(messages)
    }

    override suspend fun readMessages(): List<Message> {
        return localRepository.readMessages()
    }
}