package com.arditakrasniqi.healthclinic.presentation.screens.doctors.home


data class DoctorsHomeState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var error : String = "",
    var internet : Boolean = false
)