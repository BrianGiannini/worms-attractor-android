package dev.sangui.bigwormsattractor.view

import androidx.lifecycle.ViewModel
import dev.sangui.bigwormsattractor.logic.WormVibratorService
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SandWormViewModel(private val wormVibrationService: WormVibratorService) : ViewModel() {
    private val _toggleState = MutableStateFlow(false)
    val toggleState = _toggleState.asStateFlow()
    var toggleJob: Job? = null
        private set

    fun startPeriodicVibrator() {
        if (toggleJob?.isActive == true) return

        toggleJob = viewModelScope.launch {
            while (isActive) {
                _toggleState.value = !_toggleState.value
                delay(1000L)
            }
        }
    }

    fun stopPeriodicVibrator() {
        toggleJob?.cancel()
        toggleJob = null
    }

    fun triggerVibration() {
        wormVibrationService.vibratePhone()
    }
}