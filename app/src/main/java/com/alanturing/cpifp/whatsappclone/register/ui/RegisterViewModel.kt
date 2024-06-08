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
    data object Started: UiState()
    class Success(private val user:UserUiState):UiState()
    class Error(public val error:String):UiState()

    data object Loading: UiState()
}

@HiltViewModel
class RegisterViewModel @Inject constructor():ViewModel() {
    @Inject
    lateinit var repository: RegisterRepository
    private val user: MutableStateFlow<UiState> = MutableStateFlow(UiState.Started)
    val usuario: StateFlow<UiState>
        get() = user.asStateFlow()

    fun register(phone:String) {
        // Llamo al metodo del repositorio para realizar el usuario
        //repository.register(phone)
        viewModelScope.launch {
            val newUSer = repository.register(phone)
            if (newUSer != null) {
                user.value = UiState.Success(UserUiState(phone))
            }
            else {
                // Mostrar un mensaje de error
                user.value = UiState.Error("El usuario ya existe")
            }
        }/**/

    }

    fun isRegistered():Boolean /*= repository.isRegistered()*/ {
        viewModelScope.launch {
            val user = repository.isRegistered()
        }
        user.value = UiState.Success(UserUiState("814145143"))
        return false
    }
}