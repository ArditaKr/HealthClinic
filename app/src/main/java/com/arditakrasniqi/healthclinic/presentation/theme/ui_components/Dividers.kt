package com.arditakrasniqi.healthclinic.presentation.theme.ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomDivider(
    thickness: Dp = 1.dp,
    color: Color = Color.Black.copy(0.2f),
    modifier: Modifier = Modifier
) {
    Divider(
        thickness = thickness,
        color = color,
        modifier = modifier
            .height(thickness)
            .padding(horizontal = 20.dp)
    )
}


@Composable
fun MaxWidthDivider(
    thickness: Dp = 1.dp,
    color: Color = Color.Black.copy(0.2f),
    modifier: Modifier = Modifier
) {
    Divider(
        thickness = thickness,
        color = color,
        modifier = modifier
            .height(thickness)
    )
}