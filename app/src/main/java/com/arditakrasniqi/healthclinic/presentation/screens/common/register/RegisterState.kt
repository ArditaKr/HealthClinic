package com.arditakrasniqi.healthclinic.presentation.screens.common.register

import com.arditakrasniqi.healthclinic.data.CrudModel


data class RegisterState(
    var isLoading: Boolean = false,
    var success: Int = -1,
    var registerList : List<CrudModel> = emptyList(),
    var error : String = "",
    var internet : Boolean = false,
)