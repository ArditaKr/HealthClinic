package com.arditakrasniqi.healthclinic.presentation.utils.shared_preferences

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppSharedPreferencesImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : AppSharedPreferences {
    private val appPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun deletePrefs() {
        appPreferences.edit().clear().apply()
    }


    companion object {
        private const val SHARED_PREFERENCES = "disconnection_shared_preferences"

    }
}

