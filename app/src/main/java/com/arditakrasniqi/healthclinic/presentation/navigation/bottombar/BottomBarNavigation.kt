package com.arditakrasniqi.healthclinic.presentation.navigation.bottombar

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arditakrasniqi.healthclinic.presentation.navigation.AppScreens
import com.arditakrasniqi.healthclinic.presentation.screens.common.settings.SettingsScreen
import com.arditakrasniqi.healthclinic.presentation.screens.common.settings.SettingsViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.doctors.academia.AcademiaScreen
import com.arditakrasniqi.healthclinic.presentation.screens.doctors.academia.AcademiaViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.patients.appointments.PatientAppointmentsScreen
import com.arditakrasniqi.healthclinic.presentation.screens.patients.appointments.PatientAppointmentsViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.patients.details.PatientDetailsScreen
import com.arditakrasniqi.healthclinic.presentation.screens.patients.details.PatientDetailsViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.patients.doctors.DoctorsScreen
import com.arditakrasniqi.healthclinic.presentation.screens.patients.doctors.DoctorsViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.patients.main.PatientMainScreen
import com.arditakrasniqi.healthclinic.presentation.screens.patients.main.PatientMainViewModel

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun BottomBarNavigation(
    navController: NavHostController,
    startDestination: String
) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable(AppScreens.DoctorsScreen.route) {
            val viewModel: DoctorsViewModel = hiltViewModel()
            DoctorsScreen(navController = navController, viewModel)
        }
        composable(AppScreens.AcademiaScreen.route) {
            val viewModel: AcademiaViewModel = hiltViewModel()
            AcademiaScreen(navController = navController, viewModel)
        }
        composable(AppScreens.SettingsScreen.route) {
            val viewModel: SettingsViewModel = hiltViewModel()
            SettingsScreen(navController = navController, viewModel)
        }
        composable(AppScreens.PatientAppointmentsScreen.route) {
            val viewModel: PatientAppointmentsViewModel = hiltViewModel()
            PatientAppointmentsScreen(navController = navController, viewModel)
        }

        composable(AppScreens.PatientMainScreen.route) {
            val viewModel: PatientMainViewModel = hiltViewModel()
            PatientMainScreen(navController = navController, viewModel)
        }

        composable(AppScreens.PatientDetailsScreen.route) {
            val viewModel: PatientDetailsViewModel = hiltViewModel()
            PatientDetailsScreen(navController = navController, viewModel)
        }
    }
}

