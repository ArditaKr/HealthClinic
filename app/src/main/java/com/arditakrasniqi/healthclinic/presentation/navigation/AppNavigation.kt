package com.arditakrasniqi.healthclinic.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.arditakrasniqi.healthclinic.presentation.activities.MainViewModel
import com.arditakrasniqi.healthclinic.presentation.navigation.bottombar.BottomNavigation
import com.arditakrasniqi.healthclinic.presentation.navigation.graphs.authGraph

@OptIn(
    ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class,
    ExperimentalAnimationApi::class
)
@Composable
fun AppNavigation(
    navController: NavHostController
) {
    val mainViewModel: MainViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = AppScreens.PatientMainScreen.route

    ) {
        authGraph(navController)

    }

}

