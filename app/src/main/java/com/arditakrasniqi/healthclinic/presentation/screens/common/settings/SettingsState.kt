package com.arditakrasniqi.healthclinic.presentation.screens.common.settings


data class SettingsState(
    var isLoading: Boolean = false,
    var success: Int = -1,
    var wordsList: List<String> = emptyList(),
    var error: String = "",
    var internet: Boolean = false,
    var closeApp: Boolean = false
)