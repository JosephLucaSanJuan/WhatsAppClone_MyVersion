package com.alanturing.cpifp.whatsappclone.register.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RegisterLocalRepository @Inject constructor(
    //@ApplicationContext private val context: Context
    private val userDao: UserDao
): UserRepositoryInterface {
    override suspend fun getUsers(): List<User> {
        val users = userDao.getAllUsers()
        return users.toExternalModel()
    }

    override suspend fun createUsers(users: List<User>) {
        users.toInternalModel().forEach {
            userDao.createUser(it)
        }
    }

    override suspend fun readUsers(): List<User> {
        val users = userDao.getAllUsers()
        return users.toExternalModel()
    }
}