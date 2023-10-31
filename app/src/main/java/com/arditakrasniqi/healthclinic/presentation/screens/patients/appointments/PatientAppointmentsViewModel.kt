package com.arditakrasniqi.healthclinic.presentation.screens.patients.appointments

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.doctors.academia.AcademiaState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PatientAppointmentsViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(PatientAppointmentsState())
    val state: State<PatientAppointmentsState> = _state

    fun clearViewModel() {
        state.value.internet = false
        state.value.isLoading = false
        state.value.success = -1
        state.value.error = ""
    }

}