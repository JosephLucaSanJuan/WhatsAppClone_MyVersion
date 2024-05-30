package com.alanturing.cpifp.whatsappclone.register.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.alanturing.cpifp.whatsappclone.core.network.ContactResponse
import com.alanturing.cpifp.whatsappclone.core.network.WhatsAppCloneService
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

val PHONE_KEY = stringPreferencesKey("phone")
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Singleton
class RegisterRepository @Inject constructor(@ApplicationContext val context: Context,/**/
                                             private val networkService: WhatsAppCloneService) {
    /**/suspend fun register(phone: String):Boolean/*:User*/ {
        val newUser = User(phone = phone)
        val response = networkService.register(newUser)

        return if (response.isSuccessful)
            //response.body()
            runBlocking {
                context.dataStore.edit { settings ->
                    settings[PHONE_KEY] = phone
                }
                true
            }
        else {
            false
        }/**/
    }

    @SuppressLint("SuspiciousIndentation")
    suspend fun isRegistered():Boolean {
        val localPhone/*phoneFlow: Flow<String>*/ = context.dataStore.data.map {
            it[PHONE_KEY] ?: ""
        }.first()
        /*return runBlocking {
            phoneFlow.first() != ""
        }*/
        return if (localPhone.isBlank()) {
            false
        }
        else {
            val response = networkService.getUserByPhone(localPhone)
            response.isSuccessful && response.body()!!.phone == localPhone
        }
        /*val response = networkService.getUserByPhone("00000")
        return response.isSuccessful && response.body()!!.phone == */
    }

    suspend fun getUser():String {
        val localPhone = context.dataStore.data.map {
            it[PHONE_KEY] ?: ""
        }.first()
        return localPhone
    }
}