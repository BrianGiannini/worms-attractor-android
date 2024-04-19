package dev.sangui.bigwormsattractor.view

import android.media.SoundPool
import android.util.Log
import androidx.lifecycle.ViewModel
import dev.sangui.bigwormsattractor.logic.WormVibratorService
import androidx.lifecycle.viewModelScope
import dev.sangui.bigwormsattractor.logic.SoundEffectsService
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SandWormViewModel(
    private val wormVibrationService: WormVibratorService,
    private val soundEffectsService: SoundEffectsService
) : ViewModel() {

    private val _toggleState = MutableStateFlow(false)
    val toggleState = _toggleState.asStateFlow()

    private var toggleJob: Job? = null
    private val _isToggling = MutableStateFlow(false)
    val isToggling = _isToggling.asStateFlow()

    fun startPeriodicThumperAnimation() {

        soundEffectsService.initPool()

        // Prevent starting a new toggle if one is already active
        if (_isToggling.value) return

        toggleJob = viewModelScope.launch {
            _isToggling.value = true

            try {
                while (true) {  // Continuously toggle the value
                    if (_toggleState.value) {
                        wormVibrationService.triggerVibrator()
                        soundEffectsService.playSound(noiseId = soundEffectsService.getSound(0))
                    }
                    _toggleState.value = !_toggleState.value
                    delay(800)  // Delay for 800ms second
                }
            } finally {
                wormVibrationService.stopVibrator()
                _isToggling.value =
                    false  // Ensure _isToggling is set to false when the coroutine is finished
            }
        }
    }

    fun stopPeriodicThumperAnimation() {
        if (toggleJob?.isActive == true) {
            toggleJob?.cancel()
            wormVibrationService.stopVibrator()
            _isToggling.value = false  // Set toggling to false after stopping the job
        }
    }

}