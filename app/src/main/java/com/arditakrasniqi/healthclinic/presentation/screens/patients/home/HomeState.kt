package com.arditakrasniqi.healthclinic.presentation.screens.patients.home


data class HomeState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var error : String = "",
    var internet : Boolean = false
)