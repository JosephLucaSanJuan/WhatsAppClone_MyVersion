package com.alanturing.cpifp.whatsappclone.chat.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MessageDao {
    @Query("SELECT * FROM messages")
    suspend fun getAllMessages():List<MessageEntity>

    @Insert
    suspend fun createMessage(message: MessageEntity)

    @Delete
    suspend fun deleteMessage(message: MessageEntity)

    @Update
    suspend fun updateMessage(message: MessageEntity)
}