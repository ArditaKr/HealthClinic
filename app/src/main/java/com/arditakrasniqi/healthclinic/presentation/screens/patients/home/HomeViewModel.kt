package com.arditakrasniqi.healthclinic.presentation.screens.patients.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    fun clearViewModel() {
        state.value.internet = false
        state.value.isLoading = false
        state.value.success = -1
        state.value.error = ""
    }

}