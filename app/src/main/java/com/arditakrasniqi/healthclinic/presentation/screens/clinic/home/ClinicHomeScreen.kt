package com.arditakrasniqi.healthclinic.presentation.screens.clinic.home

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.arditakrasniqi.healthclinic.presentation.navigation.AppScreens
import com.arditakrasniqi.healthclinic.presentation.navigation.bottombar.BottomBarNavigation
import com.arditakrasniqi.healthclinic.presentation.navigation.bottombar.BottomNavigation


@OptIn(
    ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class,
    ExperimentalMaterialApi::class
)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ClinicHomeScreen(
    navController: NavController,
    viewModel: ClinicHomeViewModel
) {

    val navController = rememberNavController()

    val clinicHomeItems = listOf(
        AppScreens.SettingsScreen,
        AppScreens.SettingsScreen,
        AppScreens.SettingsScreen
    )

    Scaffold(
        bottomBar = { BottomNavigation(navController = navController, clinicHomeItems) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomBarNavigation(navController = navController, AppScreens.SettingsScreen.route)
        }
    }
}


