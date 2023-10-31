package com.arditakrasniqi.healthclinic.presentation.theme.ui_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.arditakrasniqi.healthclinic.R

@Composable
fun SuccessHeader(modifier: Modifier) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_dialog_success))

    val progress by animateLottieCompositionAsState(
        composition = composition,
    )

    LottieAnimation(composition = composition, progress = progress, modifier = modifier)

}

@Composable
fun ErrorHeader(modifier: Modifier) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_dialog_error))

    val progress by animateLottieCompositionAsState(
        composition = composition,
    )

    LottieAnimation(composition = composition, progress = progress, modifier = modifier)

}


@Composable
fun InfoHeader(modifier: Modifier) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_dialog_info))

    val progress by animateLottieCompositionAsState(
        composition = composition,
    )

    LottieAnimation(composition = composition, progress = progress, modifier = modifier)
}