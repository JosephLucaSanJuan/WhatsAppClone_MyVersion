package com.alanturing.cpifp.whatsappclone.register.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAllUsers():List<UserEntity>

    @Insert
    suspend fun createUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)
}