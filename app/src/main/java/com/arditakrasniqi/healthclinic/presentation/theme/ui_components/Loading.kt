package com.arditakrasniqi.healthclinic.presentation.theme.ui_components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.arditakrasniqi.healthclinic.R

@Composable
fun LoadingAnimation(speed: Float) {

    val compositionLoading by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.anim_loading))
    val progressLoading by animateLottieCompositionAsState(
        composition = compositionLoading,
        isPlaying = true,
        speed = speed,
        restartOnPlay = true,
        iterations = LottieConstants.IterateForever
    )

    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.padding(top = 1.dp)
    ) {

        LottieAnimation(
            composition = compositionLoading,
            progress = progressLoading,
            modifier = Modifier.size(45.dp)
        )

    }
}