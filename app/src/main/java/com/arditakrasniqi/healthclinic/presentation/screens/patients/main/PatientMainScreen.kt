package com.arditakrasniqi.healthclinic.presentation.screens.patients.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arditakrasniqi.healthclinic.R
import com.arditakrasniqi.healthclinic.presentation.theme.DeepBlue
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.CustomDivider

@Composable
fun PatientMainScreen(
    navController: NavController,
    viewModel: PatientMainViewModel
) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.dashboard),
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp),
            fontWeight = FontWeight.Bold,
            color = DeepBlue
        )

        CustomDivider(modifier = Modifier.padding(bottom = 10.dp))


    }
}