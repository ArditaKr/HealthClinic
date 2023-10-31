package com.arditakrasniqi.healthclinic.presentation.screens.doctors.academia

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AcademiaViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(AcademiaState())
    val state: State<AcademiaState> = _state

    fun clearViewModel() {
        state.value.internet = false
        state.value.isLoading = false
        state.value.success = -1
        state.value.error = ""
    }

}