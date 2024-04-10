package com.alanturing.cpifp.whatsappclone.chat.data

import javax.inject.Singleton

@Singleton
class ContactsRepository {
    private val contactos: MutableList<Contact> = mutableListOf()
    val contacts: List<Contact>
        get() = contactos.toList()

    init {
        contactos.add(Contact(1, "Camilla Jiménez)"))
    }
}