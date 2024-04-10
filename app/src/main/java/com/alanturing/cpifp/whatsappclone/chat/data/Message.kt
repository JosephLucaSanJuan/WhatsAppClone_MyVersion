package com.alanturing.cpifp.whatsappclone.chat.data

import java.time.Instant
import java.util.Date

data class Message(
    val interlocutor:String, // interlocutor del mensaje
    val texto:String, // el texto del mensaje
    val fechaYHora:Instant, // la fecha y hora en l que se lanzó el mensaje
    val entrante: Boolean // si es entrante o no
)
