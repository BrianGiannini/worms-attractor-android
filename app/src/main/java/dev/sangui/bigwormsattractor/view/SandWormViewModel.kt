package dev.sangui.bigwormsattractor.view

import dev.sangui.bigwormsattractor.logic.WormVibratorService

class SandWormViewModel(private val wormVibrationService: WormVibratorService) {

    fun triggerVibration() {
        wormVibrationService.vibratePhone()
    }
}