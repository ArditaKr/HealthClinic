package com.arditakrasniqi.healthclinic.presentation.activities

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.arditakrasniqi.healthclinic.presentation.utils.shared_preferences.AppSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferences: AppSharedPreferences,
) : ViewModel() {




}