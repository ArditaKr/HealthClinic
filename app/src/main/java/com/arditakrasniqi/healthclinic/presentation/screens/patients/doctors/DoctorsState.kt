package com.arditakrasniqi.healthclinic.presentation.screens.patients.doctors

data class DoctorsState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var error : String = "",
    var internet : Boolean = false
)