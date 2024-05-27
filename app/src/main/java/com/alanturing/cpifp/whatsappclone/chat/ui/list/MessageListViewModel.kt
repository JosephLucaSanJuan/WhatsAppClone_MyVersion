package com.alanturing.cpifp.whatsappclone.chat.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.cpifp.whatsappclone.chat.data.Message
import com.alanturing.cpifp.whatsappclone.chat.data.local.MessageLocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MessageListViewModel @Inject constructor(private val repository:MessageLocalRepository) : ViewModel() {
    private val _messageList:MutableStateFlow<List<Message>>
        = MutableStateFlow(listOf())
    val messageList:StateFlow<List<Message>>
        get() = _messageList.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                repository.getMessages()
            }
            catch (e:IOException) {}
        }
        /*viewModelScope.launch {
            repository
        }*/
    }
}