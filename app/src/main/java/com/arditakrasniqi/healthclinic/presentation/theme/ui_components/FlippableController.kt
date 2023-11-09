package com.arditakrasniqi.healthclinic.presentation.theme.ui_components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow


class FlippableController {

    private val _flipRequests = MutableSharedFlow<FlippableState>(extraBufferCapacity = 1)
    internal val flipRequests = _flipRequests.asSharedFlow()

    private var _currentSide: FlippableState = FlippableState.FRONT
    private var _flipEnabled: Boolean = true


    fun flipToFront() {
        flip(FlippableState.FRONT)
    }


    fun flipToBack() {
        flip(FlippableState.BACK)
    }


    fun flip(flippableState: FlippableState) {
        if (_flipEnabled.not())
            return

        _currentSide = flippableState
        _flipRequests.tryEmit(flippableState)
    }

    fun flip() {
        if (_currentSide == FlippableState.FRONT)
            flipToBack()
        else flipToFront()
    }

    internal fun setConfig(
        flipEnabled: Boolean = true,
    ) {
        _flipEnabled = flipEnabled
    }
}

@Composable
fun rememberFlipController(): FlippableController {
    return remember {
        FlippableController()
    }
}