package dev.sangui.bigwormsattractor.logic

import android.content.Context
import android.media.SoundPool
import dev.sangui.bigwormsattractor.R

interface SoundEffectsService {
    fun playSound(noiseId: Int)
    fun stopSound(noiseId: Int)
    fun releaseSoundPool()
    fun initPool()
    fun getSound(index: Int): Int
}

class SoundEffectsImpl(private val context: Context) : SoundEffectsService {

    private val soundPool = SoundPool.Builder()
        .setMaxStreams(2)
        .build()

    private val soundList = listOf(R.raw.loud_noise, R.raw.recall)
    private val listLoadedSounds: MutableList<Int> = mutableListOf()

    override fun getSound(index: Int)  =  listLoadedSounds[index]

    override fun initPool() {
        for (sound in soundList) {
            val loadedSound = soundPool.load(context, sound, 1)
            listLoadedSounds.add(loadedSound)
        }
    }

    override fun playSound(noiseId: Int) {
        soundPool.play(noiseId, 1f, 1f, 1, 0, 1f)
    }

    override fun stopSound(noiseId: Int) {
        soundPool.stop(noiseId)
    }

    override fun releaseSoundPool() {
        soundPool?.release()
    }

}
