package com.arditakrasniqi.healthclinic.presentation.screens.patients.appointments

data class PatientAppointmentsState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var error : String = "",
    var internet : Boolean = false
)