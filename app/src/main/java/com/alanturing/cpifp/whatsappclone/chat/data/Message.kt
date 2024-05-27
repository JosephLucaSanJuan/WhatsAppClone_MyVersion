package com.alanturing.cpifp.whatsappclone.chat.data

import kotlinx.datetime.Instant
import java.util.Date

data class Message(
    val interlocutor:Long, // interlocutor del mensaje
    val texto:String, // el texto del mensaje
    //val fechaYHora:Instant, // la fecha y hora en l que se lanzó el mensaje
    //val entrante: Boolean // si es entrante o no
)
