package com.arditakrasniqi.healthclinic.presentation.navigation.graphs


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.arditakrasniqi.healthclinic.presentation.navigation.AppScreens
import com.arditakrasniqi.healthclinic.presentation.screens.clinic.home.ClinicHomeScreen
import com.arditakrasniqi.healthclinic.presentation.screens.clinic.home.ClinicHomeViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.doctors.home.DoctorsHomeScreen
import com.arditakrasniqi.healthclinic.presentation.screens.doctors.home.DoctorsHomeViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.patients.home.HomeScreen
import com.arditakrasniqi.healthclinic.presentation.screens.patients.home.HomeViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.common.login.LoginScreen
import com.arditakrasniqi.healthclinic.presentation.screens.common.login.LoginViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.common.register.RegisterScreen
import com.arditakrasniqi.healthclinic.presentation.screens.common.register.RegisterViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.patients.appointments.PatientAppointmentsScreen
import com.arditakrasniqi.healthclinic.presentation.screens.patients.appointments.PatientAppointmentsViewModel
import com.arditakrasniqi.healthclinic.presentation.screens.patients.main.PatientMainScreen
import com.arditakrasniqi.healthclinic.presentation.screens.patients.main.PatientMainViewModel

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
fun NavGraphBuilder.authGraph(
    navController: NavController,
) {
    composable(AppScreens.LoginScreen.route) {
        val viewModel: LoginViewModel = hiltViewModel()
        LoginScreen(navController = navController, viewModel)
    }

    composable(AppScreens.RegisterScreen.route) {
        val viewModel: RegisterViewModel = hiltViewModel()
        RegisterScreen(navController = navController, viewModel)
    }

    composable(AppScreens.HomeScreen.route) {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(navController = navController, viewModel)
    }

    composable(AppScreens.DoctorsHomeScreen.route) {
        val viewModel: DoctorsHomeViewModel = hiltViewModel()
        DoctorsHomeScreen(navController = navController, viewModel)
    }

    composable(AppScreens.ClinicHomeScreen.route) {
        val viewModel: ClinicHomeViewModel = hiltViewModel()
        ClinicHomeScreen(navController = navController, viewModel)
    }



}