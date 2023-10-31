package com.arditakrasniqi.healthclinic.presentation.screens.common.login


data class LoginState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var error : String = "",
    var internet : Boolean = false
)