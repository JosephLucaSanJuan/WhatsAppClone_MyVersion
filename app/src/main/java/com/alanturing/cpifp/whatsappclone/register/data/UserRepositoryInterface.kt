package com.alanturing.cpifp.whatsappclone.register.data

interface UserRepositoryInterface {
    suspend fun getUsers(): List<User>

    suspend fun createUsers(users: List<User>)

    suspend fun readUsers(): List<User>
}