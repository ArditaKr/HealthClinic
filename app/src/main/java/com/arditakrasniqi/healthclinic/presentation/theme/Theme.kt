package com.arditakrasniqi.healthclinic.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun HealthClinicTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )



}

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}

private val LocalAppDimens = staticCompositionLocalOf {
    smallDimensions
}

object AppTheme {

    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current
}

val Dimens: Dimensions
    @Composable
    get() = AppTheme.dimens

@Composable
fun LoginScreenTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {

    val systemUiController = rememberSystemUiController()

    val configuration = LocalConfiguration.current

    val dimensions = if (configuration.screenWidthDp <= 360) smallDimensions else sw360Dimensions

    val colors = if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = DeepBlue
        )

        DarkColorPaletteLoginScreen

    } else {
        systemUiController.setSystemBarsColor(
            color = DeepBlue
        )

        LightColorPaletteLoginScreen
    }

    ProvideDimens(dimensions = dimensions) {

        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

private val DarkColorPaletteLoginScreen = darkColors(
    primary = LoginThemePrimary,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPaletteLoginScreen = lightColors(
    primary = Purple200,
    primaryVariant = LoginThemePrimary,
    secondary = LoginThemePrimary

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)
