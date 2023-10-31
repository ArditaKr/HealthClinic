package com.arditakrasniqi.healthclinic.presentation.screens.common.login

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arditakrasniqi.healthclinic.R
import com.arditakrasniqi.healthclinic.presentation.navigation.AppScreens
import com.arditakrasniqi.healthclinic.presentation.theme.AppTheme
import com.arditakrasniqi.healthclinic.presentation.theme.DeepBlue
import com.arditakrasniqi.healthclinic.presentation.theme.LoginScreenTheme
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.CustomDialogAlert
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.CustomDialogType
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.LoadingAnimation
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel,
    email: String? = null
) {

    val state = viewModel.state.value
    val context = LocalContext.current
    val intent = remember { Intent(Settings.ACTION_WIRELESS_SETTINGS) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    if (email != null) {
        LaunchedEffect(key1 = Unit) {
            username.value = email
        }
    }

    var passwordVisibility by remember { mutableStateOf(false) }

    val isErrorEmailIcon = remember { mutableStateOf(false) }

    val isErrorEmailMessage = remember { mutableStateOf("Null") }

    val isErrorPasswordMessage = remember { mutableStateOf("Null") }

    val infoDialog = remember { mutableStateOf(false) }

    if (infoDialog.value) {
        CustomDialogAlert(
            type = CustomDialogType.INFO,
            title = stringResource(R.string.information),
            desc = stringResource(R.string.no_user_registration_found),
            processText = stringResource(R.string.become_a_member),
            onProcess = {
                infoDialog.value = false
                scope.launch {

                    delay(150)
                    viewModel.clearViewModel()
                    //   navController.navigate(AppScreens.LoginScreen.withArgs(username.value))
                }
            },

            onDismiss = {
                viewModel.clearViewModel()
                infoDialog.value = false
            },
        )
    }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.ic_visibility)
    else
        painterResource(id = R.drawable.ic_visibility_off)

    when (state.success) {
        0 -> { }
        1 -> {
            LaunchedEffect(key1 = Unit) {
//                navController.navigate(SCAFFOLD_GRAPH_ROUTE) {
//                    popUpTo("Login_Screen") { inclusive = true }
//
//                }
            }
        }
    }

    LoginScreenTheme {

        Scaffold(
            scaffoldState = scaffoldState,
            snackbarHost = {

                SnackbarHost(it) {
                    Snackbar(
                        backgroundColor = Color.Red,
                        contentColor = Color.White,
                        actionColor = Color.White,
                        snackbarData = it
                    )
                }

            },
            content = {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y = (-30).dp)
                                .background(
                                    color = Color.White,
                                    RoundedCornerShape(
                                        topStart = AppTheme.dimens.grid_5,
                                        topEnd = AppTheme.dimens.grid_5
                                    )
                                )
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center, modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 80.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.logo),
                                    contentDescription = "Image Description",
                                    modifier = Modifier.size(150.dp),
                                    contentScale = ContentScale.FillBounds
                                )
                            }

                            Row(
                                horizontalArrangement = Arrangement.Center, modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = AppTheme.dimens.grid_2_5)
                            ) {

                                Text(
                                    text = stringResource(R.string.welcome),
                                    color = DeepBlue,
                                    fontSize = 29.sp,
                                    fontWeight = FontWeight.Bold
                                )

                            }

                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxSize()
                            ) {

                                Column(modifier = Modifier) {

                                    OutlinedTextField(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                start = AppTheme.dimens.grid_3_5,
                                                end = AppTheme.dimens.grid_3_5,
                                                top = AppTheme.dimens.grid_4
                                            ),
                                        value = username.value,
                                        onValueChange = { username.value = it },
                                        label = {
                                            Text(
                                                text = stringResource(R.string.username),
                                                color = Color.Black
                                            )
                                        },
                                        colors = if (!isErrorEmailIcon.value) TextFieldDefaults.outlinedTextFieldColors(

                                            backgroundColor = Color.White,
                                            textColor = Color.Black,
                                            leadingIconColor = DeepBlue,
                                            cursorColor = DeepBlue,
                                            focusedBorderColor = Color.Black,
                                            unfocusedBorderColor = Color.Gray

                                        ) else TextFieldDefaults.outlinedTextFieldColors(

                                            backgroundColor = Color.White,
                                            textColor = Color.Black,
                                            leadingIconColor = DeepBlue,
                                            cursorColor = DeepBlue,
                                            focusedBorderColor = DeepBlue,
                                            unfocusedBorderColor = DeepBlue
                                        ),

                                        leadingIcon = {

                                            IconButton(onClick = {


                                            }) {

                                                Icon(
                                                    imageVector = Icons.Filled.Email,
                                                    contentDescription = "E-Mail İcon"
                                                )

                                            }
                                        },

                                        keyboardOptions = KeyboardOptions(

                                            keyboardType = KeyboardType.Email,
                                            imeAction = ImeAction.Next
                                        ),

                                        trailingIcon = {

                                            if (isErrorEmailIcon.value)
                                                Icon(
                                                    Icons.Filled.Warning,
                                                    contentDescription = "E-Mail Error Icon",
                                                    tint = MaterialTheme.colors.error
                                                )
                                        }
                                    )

                                    if (isErrorEmailIcon.value) {
                                        Text(
                                            text = isErrorEmailMessage.value,
                                            color = MaterialTheme.colors.error,
                                            style = MaterialTheme.typography.caption,
                                            modifier = Modifier.padding(
                                                top = AppTheme.dimens.grid_1,
                                                start = AppTheme.dimens.grid_3_5
                                            )
                                        )
                                    }

                                    OutlinedTextField(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                start = AppTheme.dimens.grid_3_5,
                                                end = AppTheme.dimens.grid_3_5,
                                                top = AppTheme.dimens.grid_2
                                            ),
                                        value = password.value,
                                        onValueChange = { password.value = it },
                                        label = {
                                            Text(
                                                text = stringResource(R.string.password),
                                                color = Color.Black
                                            )
                                        },

                                        colors = if (isErrorPasswordMessage.value == "Null")

                                            TextFieldDefaults.outlinedTextFieldColors(
                                                backgroundColor = Color.White,
                                                textColor = Color.Black,
                                                leadingIconColor = DeepBlue,
                                                focusedBorderColor = Color.Black,
                                                unfocusedBorderColor = Color.Gray
                                            )
                                        else TextFieldDefaults.outlinedTextFieldColors(
                                            backgroundColor = Color.White,
                                            textColor = Color.Black,
                                            leadingIconColor = DeepBlue,
                                            focusedBorderColor = DeepBlue,
                                            unfocusedBorderColor = DeepBlue
                                        ),

                                        leadingIcon = {

                                            IconButton(onClick = {

                                            }) {

                                                Icon(
                                                    imageVector = Icons.Filled.Lock,
                                                    contentDescription = "Password İcon"
                                                )

                                            }
                                        },

                                        trailingIcon = {

                                            IconButton(onClick = {

                                                passwordVisibility = !passwordVisibility

                                            }) {

                                                Icon(
                                                    painter = icon,
                                                    contentDescription = "Password İcon"
                                                )

                                            }

                                        },

                                        visualTransformation = if (passwordVisibility) VisualTransformation.None
                                        else PasswordVisualTransformation(),

                                        singleLine = true,

                                        keyboardOptions = KeyboardOptions(

                                            keyboardType = KeyboardType.Password,
                                            imeAction = ImeAction.Done,
                                        ),

                                        keyboardActions = KeyboardActions(

                                            onDone = {

                                                keyboardController?.hide()

                                            }
                                        )
                                    )

                                    if (isErrorPasswordMessage.value != "Null") {
                                        Text(
                                            text = isErrorPasswordMessage.value,
                                            color = MaterialTheme.colors.error,
                                            style = MaterialTheme.typography.caption,
                                            modifier = Modifier.padding(
                                                top = AppTheme.dimens.grid_1,
                                                start = AppTheme.dimens.grid_3_5
                                            )
                                        )
                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.End, modifier = Modifier
                                            .padding(
                                                top = AppTheme.dimens.grid_1_5,
                                                end = AppTheme.dimens.grid_3_5
                                            )
                                            .fillMaxWidth()
                                    ) {

                                        Text(
                                            text = stringResource(R.string.i_forgot_my_password),
                                            color = Color.Gray
                                        )

                                    }

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(
                                                start = AppTheme.dimens.grid_3_5 * 2,
                                                end = AppTheme.dimens.grid_3_5 * 2,
                                                top = AppTheme.dimens.grid_1_5 * 2
                                            ),
                                        horizontalArrangement = Arrangement.Center
                                    ) {

                                        Button(
                                            onClick = {

                                                when (LoginUtils().loginFormatValidation(
                                                    username.value,
                                                    password.value
                                                )) {

                                                    1 -> {
                                                        when(username.value){
                                                            "clinic@gmail.com" ->  navController.navigate(AppScreens.ClinicHomeScreen.route)
                                                            "doctor@gmail.com" -> navController.navigate(AppScreens.DoctorsHomeScreen.route)
                                                            "patient@gmail.com" -> navController.navigate(AppScreens.HomeScreen.route)
                                                        }
                                                    }

                                                    2 -> {

                                                        isErrorEmailIcon.value = true
                                                        isErrorEmailMessage.value =
                                                            context.getString(R.string.please_enter_your_email)

                                                    }

                                                    3 -> {

                                                        isErrorEmailIcon.value = true
                                                        isErrorEmailMessage.value =
                                                            context.getString(R.string.email_too_short)

                                                    }

                                                    4 -> {

                                                        isErrorEmailIcon.value = true
                                                        isErrorEmailMessage.value =
                                                            context.getString(R.string.invalid_email_format)

                                                    }

                                                    5 -> {

                                                        isErrorEmailIcon.value = false
                                                        isErrorEmailMessage.value = "Null"
                                                        isErrorPasswordMessage.value =
                                                            context.getString(R.string.please_enter_your_password)

                                                    }
                                                }
                                            },
                                            shape = RoundedCornerShape(AppTheme.dimens.grid_4),
                                            modifier = Modifier
                                                .fillMaxWidth(),

                                            colors = ButtonDefaults.buttonColors(
                                                backgroundColor = DeepBlue,
                                                contentColor = Color.White
                                            )

                                        ) {

                                            Text(

                                                text = stringResource(R.string.log_in),
                                                fontSize = 18.sp,
                                                modifier = Modifier
                                                    .padding(
                                                        top = AppTheme.dimens.grid_1,
                                                        bottom = AppTheme.dimens.grid_1
                                                    )

                                            )
                                        }
                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {

                                        if (state.isLoading) {

                                            LoadingAnimation(speed = 4f)

                                        }
                                    }
                                }

                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.Bottom,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {

                                    Text(text = stringResource(R.string.don_t_have_an_account))

                                    Spacer(modifier = Modifier.padding(AppTheme.dimens.grid_0_5))

                                    Text(text = stringResource(R.string.become_a_member),
                                        color = DeepBlue,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .clickable {
                                                scope.launch {
                                                    viewModel.clearViewModel()
                                                    navController.navigate(AppScreens.RegisterScreen.route)
                                                }
                                            }
                                    )
                                }
                            }
                        }


                    if (state.internet) {

                        LaunchedEffect(key1 = Unit) {

                            scope.launch {

                                val sb = scaffoldState.snackbarHostState.showSnackbar(
                                    context.getString(R.string.no_internet_connection_found),
                                    actionLabel = context.getString(R.string.settings),
                                    duration = SnackbarDuration.Long
                                )

                                if (sb == SnackbarResult.ActionPerformed) {

                                    context.startActivity(intent)

                                }
                            }
                        }
                    }
                }
            }
        )
    }
}