package com.arditakrasniqi.healthclinic.presentation.screens.clinic.home


data class ClinicHomeState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var error : String = "",
    var internet : Boolean = false
)