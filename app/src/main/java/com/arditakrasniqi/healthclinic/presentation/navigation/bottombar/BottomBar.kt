package com.arditakrasniqi.healthclinic.presentation.navigation.bottombar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppsOutage
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.arditakrasniqi.healthclinic.R
import com.arditakrasniqi.healthclinic.presentation.navigation.AppScreens
import com.arditakrasniqi.healthclinic.presentation.theme.DeepBlue

@Composable
fun BottomNavigation(navController: NavHostController, items: List<AppScreens>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    BottomNavigation(
        backgroundColor = DeepBlue,
        contentColor = Color.White
    ) {
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    when (item) {
                        AppScreens.DoctorsScreen -> Icon(
                            imageVector = Icons.Default.PersonOutline,
                            tint = Color.White,
                            contentDescription = null
                        )

                        AppScreens.AcademiaScreen -> Icon(
                            painterResource(id = R.drawable.ic_academia),
                            contentDescription = null
                        )

                        AppScreens.SettingsScreen -> Icon(
                            painterResource(id = R.drawable.ic_academia),
                            contentDescription = null
                        )

                        AppScreens.PatientMainScreen -> Icon(
                            imageVector = Icons.Default.Home,
                            tint = Color.White,
                            contentDescription = null
                        )

                        AppScreens.PatientAppointmentsScreen -> Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            tint = Color.White,
                            contentDescription = null
                        )

                        AppScreens.PatientDetailsScreen -> Icon(
                            imageVector = Icons.Default.Folder,
                            tint = Color.White,
                            contentDescription = null
                        )

                        else -> {}
                    }
                },
                label = { Text(text = item.route, fontSize = 9.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
