package dev.sangui.bigwormsattractor.view

import androidx.lifecycle.ViewModel
import dev.sangui.bigwormsattractor.logic.WormVibratorService
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SandWormViewModel(private val wormVibrationService: WormVibratorService) : ViewModel() {

    private val _toggleState = MutableStateFlow(false)
    val toggleState = _toggleState.asStateFlow()

    private var toggleJob: Job? = null
    private val _isToggling = MutableStateFlow(false)
    val isToggling = _isToggling.asStateFlow()

    fun startPeriodicVibrator() {
        // Prevent starting a new toggle if one is already active
        if (_isToggling.value) return

        toggleJob = viewModelScope.launch {
            _isToggling.value = true
            try {
                while (true) {  // Continuously toggle the value
                    _toggleState.value = !_toggleState.value
                    delay(1000)  // Delay for 1 second
                }
            } finally {
                _isToggling.value =
                    false  // Ensure _isToggling is set to false when the coroutine is finished
            }
        }
    }

    fun stopPeriodicVibrator() {
        if (toggleJob?.isActive == true) {
            toggleJob?.cancel()
            _isToggling.value = false  // Set toggling to false after stopping the job
        }
    }

    fun triggerVibration() {
        wormVibrationService.vibratePhone()
    }
}