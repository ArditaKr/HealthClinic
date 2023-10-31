package com.arditakrasniqi.healthclinic.presentation.di

import android.content.Context
import androidx.camera.core.*
import com.arditakrasniqi.healthclinic.presentation.utils.shared_preferences.AppSharedPreferences
import com.arditakrasniqi.healthclinic.presentation.utils.shared_preferences.AppSharedPreferencesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun bindSharedPreferences(@ApplicationContext context: Context):
            AppSharedPreferences = AppSharedPreferencesImpl(context)


}