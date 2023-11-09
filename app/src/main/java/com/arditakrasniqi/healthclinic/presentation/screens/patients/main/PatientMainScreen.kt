package com.arditakrasniqi.healthclinic.presentation.screens.patients.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arditakrasniqi.healthclinic.R
import com.arditakrasniqi.healthclinic.presentation.theme.DeepBlue
import com.arditakrasniqi.healthclinic.presentation.theme.LightBlue
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.CustomDivider
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.FlipAnimationType
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.Flippable
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.FlippableController
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.rememberFlipController

@Composable
fun PatientMainScreen(
    navController: NavController, viewModel: PatientMainViewModel
) {
    Column(
        verticalArrangement = Arrangement.Top, modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Text(
            text = stringResource(id = R.string.dashboard),
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp),
            fontWeight = FontWeight.Bold,
            color = DeepBlue
        )

        CustomDivider(modifier = Modifier.padding(bottom = 10.dp))




        Text(
            text = "Welcome, Patient",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 10.dp),
            fontSize = 24.sp,
            color = DeepBlue
        )
        ImageTextLayout()

        ImageTextLayout2()
        ImageTextLayout3()
        Spacer(modifier = Modifier.height(15.dp))
        ImageTextLayout4()

    }
}


@Composable
fun Flippable(painter: Painter, modifier: Modifier, controller: FlippableController) {

    Flippable(frontSide = {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = modifier
        )
    },
        backSide = {
            Image(
                painter = painter,
                contentDescription = "",
                modifier = modifier
            )

        },
        flipController = controller,
        flipDurationMs = 500,
        flipEnabled = true,
        contentAlignment = Alignment.TopCenter,
        autoFlip = true,
        autoFlipDurationMs = 1000,
        flipAnimationType = FlipAnimationType.HORIZONTAL_CLOCKWISE,
        cameraDistance = 30.0F,
        onFlippedListener = { currentSide ->
        })


}

@Composable
fun UpcomingAppointments() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Upcoming Appointments",
                style = MaterialTheme.typography.h6,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Display a list of upcoming appointments
            // You can use a LazyColumn or other suitable Composables here
        }
    }
}

@Composable
fun RecentTestResults() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Recent Test Results",
                style = MaterialTheme.typography.h6,
                fontSize = 20.sp,
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Display a list of recent test results
            // You can use a LazyColumn or other suitable Composables here
        }
    }
}

@Composable
fun ImageTextLayout() {
    // Create a Column layout to place the text and image vertically
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Create a Row layout to place the image and text side by side
        Row(
            modifier = Modifier.padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Create a Text composable for the left part
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Text(
                    text = "Your health,\nour mission",
                    modifier = Modifier.padding(bottom = 5.dp),
                    fontSize = 25.sp,
                    color = DeepBlue
                )
                Text(
                    text = "Addressing every\nneed", fontSize = 20.sp, color = DeepBlue
                )
            }
            // Create an Image composable for the right part
            val controller = rememberFlipController()
            Flippable(
                painterResource(id = R.drawable.medical_image), modifier = Modifier
                    .size(200.dp)
                    .padding(start = 16.dp, bottom = 10.dp), controller
            )


        }
    }
}

@Composable
fun ImageTextLayout2() {
    // Create a Column layout to place the text and image vertically
    Column(
        modifier = Modifier.padding(16.dp)
            .background(
                color = LightBlue,
                shape = RoundedCornerShape(16.dp) // Adjust the radius as needed
            ), // Adjust the padding as needed
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Create a Row layout to place the image and text side by side
        Row(
            modifier = Modifier.padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Create a Text composable for the left part
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Text(
                    text = "Introduction:\nOur commitment\nto your\nwell-being",
                    modifier = Modifier.padding(bottom = 5.dp, top = 20.dp),
                    fontSize = 20.sp,
                    color = DeepBlue
                )
            }
            // Create an Image composable for the right part
            val controller = rememberFlipController()
            Flippable(
                painterResource(id = R.drawable.ic_medical2), modifier = Modifier
                    .size(200.dp)
                    .padding(start = 16.dp), controller
            )
        }
    }
}

@Composable
fun ImageTextLayout3() {
    // Create a Column layout to place the text and image vertically
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        // Create a Text composable for the title
        Text(
            text = "Our medical team:",
            color = DeepBlue,
            fontSize = 22.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Dedicated professionals",
            color = DeepBlue,
            fontSize = 22.sp,
        )

        // Create a Row layout to place three identical image-text pairs side by side
        Row(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ImageTextPair(painterResource(id = R.drawable.doctor1), "Emily Berts", "Pediatrician")
            ImageTextPair(painterResource(id = R.drawable.doctor2), "Mich Anerson", "Cardiologist")
            ImageTextPair(painterResource(id = R.drawable.doctor3), "Sophia Iams", "Gynecologist")
        }
    }
}

@Composable
fun ImageTextPair(painter: Painter, doctorName: String, description: String) {
    val controller = rememberFlipController()
    Column(
        modifier = Modifier.padding(top = 20.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Flippable(
            painter,
            modifier = Modifier.size(100.dp),
            controller
        )
        Text(
            text = doctorName,
            modifier = Modifier.padding(bottom = 5.dp, top = 16.dp),
            fontSize = 15.sp,
            color = DeepBlue,
            textAlign = TextAlign.Center
        )
        Text(
            text = description,
            fontSize = 15.sp,
            color = DeepBlue,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun ImageTextLayout4() {
    // Create a Column layout to place the text and image vertically
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier.padding(bottom = 50.dp)
    ) {
        // Create a Row layout to place the image and text side by side
        Row(
            modifier = Modifier.padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Create a Text composable for the left part
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Text(
                    text = "Personalized care:\nListening to\nthe patient",
                    modifier = Modifier.padding(bottom = 5.dp, top = 20.dp),
                    fontSize = 20.sp,
                    color = DeepBlue
                )
            }
            // Create an Image composable for the right part
            val controller = rememberFlipController()
            Flippable(
                painterResource(id = R.drawable.ic_medical3), modifier = Modifier
                    .size(200.dp)
                    .padding(start = 16.dp), controller
            )


        }
    }
}

