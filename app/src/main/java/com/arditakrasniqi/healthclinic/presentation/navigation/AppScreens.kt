package com.arditakrasniqi.healthclinic.presentation.navigation

sealed class AppScreens(val route: String) {

    object LoginScreen : AppScreens("login")
    object RegisterScreen : AppScreens("register")
    object HomeScreen : AppScreens("home")
    object AcademiaScreen : AppScreens("academia")
    object SettingsScreen : AppScreens("settings")
    object DoctorsScreen : AppScreens("Doctors")

    object ClinicHomeScreen : AppScreens("clinic_home")
    object DoctorsHomeScreen : AppScreens("doctors_home")
    object PatientAppointmentsScreen: AppScreens("Appointments")
    object PatientMainScreen: AppScreens("Home")
    object PatientDetailsScreen: AppScreens("Details")
}
