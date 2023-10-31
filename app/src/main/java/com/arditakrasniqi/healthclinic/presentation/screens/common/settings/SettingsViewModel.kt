package com.arditakrasniqi.healthclinic.presentation.screens.common.settings

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    private val _stateSettings = mutableStateOf(SettingsState())
    val stateSettings: State<SettingsState> = _stateSettings

    fun changeState() {

        Log.e("View Model Tetik", "Çalıştı")

        viewModelScope.launch {

            _stateSettings.value = SettingsState(
                closeApp = true
            )

        }



    }


}