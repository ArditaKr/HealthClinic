package com.arditakrasniqi.healthclinic.presentation.screens.doctors.academia

data class AcademiaState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var error : String = "",
    var internet : Boolean = false
)