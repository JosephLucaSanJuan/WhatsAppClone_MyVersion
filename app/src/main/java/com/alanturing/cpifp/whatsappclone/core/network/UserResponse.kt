package com.alanturing.cpifp.whatsappclone.core.network

import com.alanturing.cpifp.whatsappclone.register.data.User

data class UserResponse(
    //val id: Long,
    val phone: String
) {

}

fun List<UserResponse>.toExternalModel(): List<User> {
    return this.map {
        User(
            //id = it.id,
            phone = it.phone,
        )
    }
}