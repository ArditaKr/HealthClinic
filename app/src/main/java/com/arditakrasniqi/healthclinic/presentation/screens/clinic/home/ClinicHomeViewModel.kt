package com.arditakrasniqi.healthclinic.presentation.screens.clinic.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.doctors.home.DoctorsHomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClinicHomeViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(DoctorsHomeState())
    val state: State<DoctorsHomeState> = _state

    fun clearViewModel() {
        state.value.internet = false
        state.value.isLoading = false
        state.value.success = -1
        state.value.error = ""
    }

}