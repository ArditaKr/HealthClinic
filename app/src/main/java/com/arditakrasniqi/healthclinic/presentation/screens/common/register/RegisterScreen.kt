package com.arditakrasniqi.healthclinic.presentation.screens.common.register

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
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
import com.arditakrasniqi.healthclinic.presentation.theme.DeepBlue
import com.arditakrasniqi.healthclinic.presentation.theme.LoginScreenTheme
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.CustomDialogAlert
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.CustomDialogType
import com.arditakrasniqi.healthclinic.presentation.theme.ui_components.LoadingAnimation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalComposeUiApi
@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel
) {

    LoginScreenTheme {

        val scaffoldState = rememberScaffoldState()

        val scope = rememberCoroutineScope()

        val keyboardController = LocalSoftwareKeyboardController.current

        val state = viewModel.state.value

        val context = LocalContext.current

        val username = remember {
            mutableStateOf("")
        }

        val checkboxDurum = remember {
            mutableStateOf(true)
        }

        val passwordOne = remember {
            mutableStateOf("")
        }

        val passwordTwo = remember {
            mutableStateOf("")
        }

        val isErrorEmailIcon = remember {
            mutableStateOf(false)
        }

        val isErrorEmailMessage = remember {
            mutableStateOf("Null")
        }

        val isErrorPasswordMessage = remember {
            mutableStateOf("Null")
        }

        var passwordVisibility by remember {
            mutableStateOf(false)
        }

        var passwordVisibilityTwo by remember {
            mutableStateOf(false)
        }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.ic_visibility)
        else
            painterResource(id = R.drawable.ic_visibility_off)

        val iconTwo = if (passwordVisibilityTwo)
            painterResource(id = R.drawable.ic_visibility_two)
        else
            painterResource(id = R.drawable.ic_visibility_off_two)

        val succesDialog = remember {
            mutableStateOf(false)
        }

        val infoDialog = remember {
            mutableStateOf(false)
        }

        if (succesDialog.value) {

            CustomDialogAlert(
                type = CustomDialogType.SUCCESS,
                title = stringResource(R.string.congratulations),
                desc = stringResource(R.string.registration_successful),
                processText = stringResource(R.string.log_in),

                onProcess = {

                    succesDialog.value = false

                    scope.launch {
                        delay(150)

                        viewModel.clearSignInViewModel()

                        //     navController.navigate(ScreenList.LoginScreen.withArgs(username.value)) {
//
//                            popUpTo("SignIn_Screen") { inclusive = true }
//                            popUpTo("Login_Screen") { inclusive = true }

                        //  }

                    }

                },

                onDismiss = {

                    viewModel.clearSignInViewModel()

                    succesDialog.value = false

                },


                )

        }

        if (infoDialog.value) {

            CustomDialogAlert(
                type = CustomDialogType.INFO,
                title = stringResource(id = R.string.information),
                desc = stringResource(R.string.another_user_registered),
                processText = stringResource(R.string.log_in),

                onProcess = {

                    infoDialog.value = false

                    scope.launch {
                        viewModel.clearSignInViewModel()

                        navController.navigate(AppScreens.LoginScreen.route) {


                        }
                    }

                },

                onDismiss = {

                    viewModel.clearSignInViewModel()

                    infoDialog.value = false

                },
            )

        }


        when (state.success) {

            0 -> {


            }

            1 -> {

                succesDialog.value = true
                state.success = -1

            }

            210 -> {

                infoDialog.value = true
                state.success = -1

            }
        }


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

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = (-30).dp)
                            .background(
                                color = Color.White,
                                RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
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

                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {

                            Column() {

                                OutlinedTextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 20.dp, end = 20.dp, top = 15.dp),
                                    value = username.value,
                                    onValueChange = { username.value = it },
                                    label = {
                                        Text(
                                            text = stringResource(R.string.e_mail),
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
                                        focusedBorderColor = Color.Red,
                                        unfocusedBorderColor = Color.Red
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

                                    trailingIcon = {

                                        if (isErrorEmailIcon.value)
                                            Icon(
                                                Icons.Filled.Warning,
                                                contentDescription = "E-Mail Error Icon",
                                                tint = MaterialTheme.colors.error
                                            )
                                    },

                                    keyboardOptions = KeyboardOptions(

                                        keyboardType = KeyboardType.Email,
                                        imeAction = ImeAction.Next

                                    )

                                )

                                if (isErrorEmailIcon.value) {
                                    Text(
                                        text = isErrorEmailMessage.value,
                                        color = MaterialTheme.colors.error,
                                        style = MaterialTheme.typography.caption,
                                        modifier = Modifier.padding(top = 5.dp, start = 20.dp)
                                    )
                                }

                                OutlinedTextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                                    value = passwordOne.value,
                                    onValueChange = { passwordOne.value = it },
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

                                        ) else

                                        TextFieldDefaults.outlinedTextFieldColors(
                                            backgroundColor = Color.White,
                                            textColor = Color.Black,
                                            leadingIconColor = DeepBlue,
                                            focusedBorderColor = Color.Red,
                                            unfocusedBorderColor = Color.Red
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

                                        keyboardType = KeyboardType.Email,
                                        imeAction = ImeAction.Next

                                    )

                                )

                                OutlinedTextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 20.dp, end = 20.dp, top = 5.dp),
                                    value = passwordTwo.value,
                                    onValueChange = { passwordTwo.value = it },
                                    label = {
                                        Text(
                                            text = stringResource(R.string.verify_password),
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

                                        ) else

                                        TextFieldDefaults.outlinedTextFieldColors(
                                            backgroundColor = Color.White,
                                            textColor = Color.Black,
                                            leadingIconColor = DeepBlue,
                                            focusedBorderColor = Color.Red,
                                            unfocusedBorderColor = Color.Red
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

                                            passwordVisibilityTwo = !passwordVisibilityTwo

                                        }) {
                                            Icon(
                                                painter = iconTwo,
                                                contentDescription = "Password İcon"
                                            )
                                        }

                                    },

                                    visualTransformation = if (passwordVisibilityTwo) VisualTransformation.None
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
                                        modifier = Modifier.padding(top = 5.dp, start = 20.dp)
                                    )
                                }

                                Row(
                                    modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Checkbox(
                                        checked = checkboxDurum.value,
                                        onCheckedChange = {
                                            checkboxDurum.value = it
                                        },

                                        colors = CheckboxDefaults.colors(

                                            checkedColor = DeepBlue

                                        )
                                    )

                                    Text(
                                        text = stringResource(R.string.i_agree_to_the_user_agreement),
                                        fontSize = 14.sp,
                                        modifier = Modifier
                                            .padding(start = 5.dp)
                                    )

                                }


                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 50.dp, end = 50.dp, top = 30.dp),
                                    horizontalArrangement = Arrangement.Center
                                ) {

                                    Button(
                                        onClick = {

                                            scope.launch {

                                                when (RegisterUtils().registerFormatValidation(
                                                    username.value,
                                                    passwordOne.value,
                                                    passwordTwo.value

                                                )) {

                                                    1 -> {

                                                        isErrorEmailIcon.value = false
                                                        isErrorPasswordMessage.value = "Null"

                                                        val postUsername = username.value.trim()
                                                        val postPassword =
                                                            passwordTwo.value.trim()

//                                                        viewModel.getRegisterUser(
//                                                            Constants.REGISTER,
//                                                            Constants.TYPETWO,
//                                                            postUsername,
//                                                            postPassword
//                                                        )

                                                    }

                                                    2 -> {

                                                        isErrorEmailIcon.value = true
                                                        isErrorEmailMessage.value =
                                                            context.getString(R.string.please_enter_your_email)
                                                        isErrorPasswordMessage.value = "Null"

                                                    }

                                                    3 -> {

                                                        isErrorEmailIcon.value = true
                                                        isErrorEmailMessage.value =
                                                            context.getString(R.string.email_too_short)
                                                        isErrorPasswordMessage.value = "Null"

                                                    }

                                                    4 -> {

                                                        isErrorEmailIcon.value = true
                                                        isErrorEmailMessage.value =
                                                            context.getString(R.string.invalid_email_format)
                                                        isErrorPasswordMessage.value = "Null"

                                                    }

                                                    5 -> {

                                                        isErrorEmailIcon.value = false
                                                        isErrorPasswordMessage.value =
                                                            context.getString(R.string.please_enter_your_password)

                                                    }

                                                    6 -> {

                                                        isErrorEmailIcon.value = false
                                                        isErrorPasswordMessage.value =
                                                            context.getString(R.string.passwords_do_not_match)

                                                    }

                                                    7 -> {

                                                        isErrorEmailIcon.value = false
                                                        isErrorPasswordMessage.value =
                                                            context.getString(R.string.password_must_be_at_least_8_characters)

                                                    }

                                                }

                                            }

                                        },
                                        shape = RoundedCornerShape(25.dp),
                                        modifier = Modifier
                                            .fillMaxWidth(),

                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = DeepBlue,
                                            contentColor = Color.White
                                        )

                                    ) {

                                        Text(

                                            text = stringResource(id = R.string.become_a_member),
                                            fontSize = 18.sp,
                                            modifier = Modifier
                                                .padding(top = 5.dp, bottom = 5.dp)

                                        )

                                    }
                                }

                                if (state.isLoading) {

                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 3.dp)
                                    ) {

                                        LoadingAnimation(speed = 3.75f)

                                    }

                                }
                            }

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.Bottom,
                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Text(text = stringResource(R.string.already_have_an_account))
                                Spacer(modifier = Modifier.padding(3.dp))
                                Text(
                                    text = stringResource(id = R.string.log_in),
                                    color = DeepBlue,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.clickable {

                                        navController.navigate(AppScreens.LoginScreen.route) {


                                        }

                                    })
                            }
                        }
                    }
                }
            }
        )
    }

}