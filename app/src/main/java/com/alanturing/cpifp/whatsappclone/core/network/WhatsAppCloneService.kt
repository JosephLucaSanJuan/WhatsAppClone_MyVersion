package com.alanturing.cpifp.whatsappclone.core.network

import com.alanturing.cpifp.whatsappclone.register.data.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface WhatsAppCloneService {
    @GET("/message")
    fun getAllMessages(/*@Query("user") userId:Long*/): Response<List<MessageResponse>>

    @POST("message")
    suspend fun createMessage(message: MessageRequest): Response<MessageResponse>

    @POST("user")
    suspend fun register(@Body user: User):Response<UserResponse>

    @GET("user")
    suspend fun getAllUsers(): List<User>

    @GET("user")
    suspend fun getUserByPhone(@Query("phone") phone:String): Response<UserResponse>
}