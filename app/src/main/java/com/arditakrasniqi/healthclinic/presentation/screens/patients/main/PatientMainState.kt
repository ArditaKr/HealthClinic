package com.arditakrasniqi.healthclinic.presentation.screens.patients.main

data class PatientMainState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var error : String = "",
    var internet : Boolean = false
)