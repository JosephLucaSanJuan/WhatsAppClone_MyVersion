package com.alanturing.cpifp.whatsappclone.register.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.cpifp.whatsappclone.register.data.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiState {
    object started: UiState()
    class success(private val User:UserUiState):UiState()
    class error(public val error:String):UiState()

    object loading: UiState()
}

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: RegisterRepository):ViewModel() {
    private val user: MutableStateFlow<UiState> = MutableStateFlow(UiState.started)
    val usuario: StateFlow<UiState>
        get() = user.asStateFlow()

    fun register(phone:String) {
        // Llamo al metodo del repositorio para realizar el usuario
        //repository.register(phone)
        viewModelScope.launch {
            val newUSer = repository.register(phone)
            if (newUSer != null) {
                user.value = UiState.success(UserUiState(phone))
            }
            else {
                // Mostrar un mensaje de error
                user.value = UiState.error("El usuario ya existe")
            }
        }/**/

    }

    fun isRegistered():Boolean /*= repository.isRegistered()*/ {
        viewModelScope.launch {
            val user = repository.isRegistered()
        }
        user.value = UiState.success(UserUiState("814145143"))
        return false
    }
}