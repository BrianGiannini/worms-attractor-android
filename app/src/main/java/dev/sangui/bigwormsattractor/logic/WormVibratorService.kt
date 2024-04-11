package dev.sangui.bigwormsattractor.logic

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.content.ContextCompat.getSystemService

// Vibrate with a pattern

interface WormVibratorService {
    fun vibratePhone()
}

class WormVibratorServiceImpl(private val context: Context): WormVibratorService {

    override fun vibratePhone() {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = getSystemService(context, android.os.VibratorManager::class.java)
            vibratorManager?.defaultVibrator
        } else {
            getSystemService(context, Vibrator::class.java)
        }

        if (vibrator?.hasVibrator() == true) { // Check if the device has a vibrator
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // New method for API Level 26 (Android 8.0 Oreo) and above
                val effect = VibrationEffect.createWaveform(longArrayOf(0, 100, 1000, 300), 1)
                vibrator.vibrate(effect)
            } else {
                // Deprecated method for below API Level 26
                @Suppress("DEPRECATION")
                vibrator.vibrate(500)
            }
        }
    }
}
