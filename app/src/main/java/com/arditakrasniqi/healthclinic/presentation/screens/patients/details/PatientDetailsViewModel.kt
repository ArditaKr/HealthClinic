package com.arditakrasniqi.healthclinic.presentation.screens.patients.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.doctors.academia.AcademiaState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PatientDetailsViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(PatientDetailsState())
    val state: State<PatientDetailsState> = _state

    fun clearViewModel() {
        state.value.internet = false
        state.value.isLoading = false
        state.value.success = -1
        state.value.error = ""
    }

}