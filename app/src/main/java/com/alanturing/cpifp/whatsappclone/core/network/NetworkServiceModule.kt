package com.alanturing.cpifp.whatsappclone.core.network

import android.content.Context
import androidx.room.Room
import com.alanturing.cpifp.whatsappclone.chat.data.MessageNetworkRepository
import com.alanturing.cpifp.whatsappclone.chat.data.MessageRepository
import com.alanturing.cpifp.whatsappclone.chat.data.MessageRepositoryInterface
import com.alanturing.cpifp.whatsappclone.chat.data.local.AppDatabase
import com.alanturing.cpifp.whatsappclone.chat.data.local.MessageDao
import com.alanturing.cpifp.whatsappclone.chat.data.local.MessageLocalRepository
import com.alanturing.cpifp.whatsappclone.register.data.RegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkServiceModule {
    // Local
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context):AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            name = "app_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMessageDao(database: AppDatabase):MessageDao {
        return database.messageDao()
    }

    @Provides
    @Singleton
    fun provideConverterFactory():Converter.Factory {
        return GsonConverterFactory.create()
    }

    // Network
    @Provides
    @Singleton
    fun provideNetworkService(converterFactory: Converter.Factory): WhatsAppCloneService {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://1a92-83-60-148-5-.ngrok-free.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(WhatsAppCloneService::class.java)
    }

    // Repositories
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class NetworkRepository

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalRepository

    @Provides
    @Singleton
    @LocalRepository
    fun provideLocalRepository(dao: MessageDao):MessageRepositoryInterface {
        return MessageLocalRepository(dao)
    }

    @Provides
    @Singleton
    @NetworkRepository
    fun provideNetworkRepository(api: WhatsAppCloneService, regRep: RegisterRepository):MessageRepositoryInterface{
        return MessageNetworkRepository(api, regRep)
    }

    @Provides
    @Singleton
    fun provideMessageRepository(
        @LocalRepository localRepository: MessageRepositoryInterface,
        @NetworkRepository networkRepository: MessageRepositoryInterface
    ):MessageRepositoryInterface {
        return MessageRepository(
            networkRepository,localRepository
        )
    }
}