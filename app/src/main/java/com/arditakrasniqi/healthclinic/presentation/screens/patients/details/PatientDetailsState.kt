package com.arditakrasniqi.healthclinic.presentation.screens.patients.details

data class PatientDetailsState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var error : String = "",
    var internet : Boolean = false
)