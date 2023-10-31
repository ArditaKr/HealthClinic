package com.arditakrasniqi.healthclinic.presentation.screens.common.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state


    fun clearSignInViewModel() {
        state.value.internet = false
        state.value.isLoading = false
        state.value.success = -1
        state.value.registerList = emptyList()
        state.value.error = ""

    }
}
