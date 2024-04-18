package dev.sangui.bigwormsattractor.logic

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

interface WormVibratorService {
    fun triggerVibrator()
    fun stopVibrator()
}

class WormVibratorServiceImpl(private val context: Context): WormVibratorService {

    private var vibrator: Vibrator? = null

    override fun triggerVibrator() {

        vibrator =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? android.os.VibratorManager
            vibratorManager?.defaultVibrator
        } else {
            context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        }

        val pattern = longArrayOf(200, 700, 600)
        val amplitude = intArrayOf(0, 255,0 )
        val repeat = -1  // Triggering once

        if (vibrator?.hasVibrator() == true) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val effect = VibrationEffect.createWaveform(pattern, amplitude, repeat)
                vibrator?.vibrate(effect)
            } else {
                @Suppress("DEPRECATION")
                vibrator?.vibrate(pattern, repeat)
            }
        }
    }

    override fun stopVibrator() {
        vibrator?.cancel()
        vibrator = null
    }
}
