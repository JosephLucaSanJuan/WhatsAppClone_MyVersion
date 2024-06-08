package com.alanturing.cpifp.whatsappclone.register.data

class UserRepository constructor(
    private val registerRepository: RegisterRepository,
    private val registerLocalRepository: RegisterLocalRepository
): UserRepositoryInterface {
    override suspend fun getUsers(): List<User> {
        /*val response = registerRepository.getUser()
        createUsers(response)*/
        return registerLocalRepository.getUsers()
    }

    override suspend fun createUsers(users: List<User>) {
        /*users.toInternalModel().forEach {
            registerRepository.register()
        }*/
        return registerLocalRepository.createUsers(users)
    }

    override suspend fun readUsers(): List<User> {
        return registerLocalRepository.getUsers()
    }
}