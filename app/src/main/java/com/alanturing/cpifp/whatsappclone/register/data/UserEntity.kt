package com.alanturing.cpifp.whatsappclone.register.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    //@PrimaryKey val id: Long,
    val phone: String
)

fun List<UserEntity>.toExternalModel(): List<User> {
    return this.map {
        User(
            //id = it.id,
            phone = it.phone
        )
    }
}

fun List<User>.toInternalModel(): List<UserEntity> {
    return this.map {
        UserEntity(
            //id = it.id,
            phone = it.phone
        )
    }
}
